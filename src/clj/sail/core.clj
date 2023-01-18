(ns sail.core
  (:require [juxt.dirwatch :as dw]
            [clojure.java.io :as io]
            [clojure.string :as s]
            [sail.normalize :refer [normalize]]
            ;; [clojure.tools.logging.impl]
            [taoensso.timbre :as log]
            [taoensso.timbre.appenders.core :as log-appenders]
            [sail.base :refer [base]]
            [sail.components :refer [components]]
            [sail.accessibility :refer [accessibility]]
            [sail.transition :refer [transition]]))

(log/merge-config!
  {:appenders {:println (log-appenders/println-appender
                          {:stream (java.io.OutputStreamWriter. System/out)})}})

(defn prefix
  "Include . for class names, ignore for reserved words like 'html'."
  [n]
  ;; TODO generate these definitions based on the normalize array map,
  ;; this is PRETTY long and you will need to maintain it otherwise.
  (if (contains? #{:html :body :main :h1 :h2 :h3 :h4 :h5 :h6 
                   :section :nav :header :footer :hr :pre :a
                   :b :strong :code :kbd :samp :small :sub :sup :img
                   :svg :video :canvas :audio :iframe :embed :object
                   :button :input :optgroup :select :textarea
                   :fieldSet :legend :progress :details :summary
                   :template :* :blockquote :dl :dd :tr :td :thead
                   :tbody :table :figure :p :button:focus :ol :ul :li
                   (keyword "::before")
                   (keyword "::after")
                   (keyword "[type=\"checkbox\"]")
                   (keyword "[type=\"radio\"]")
                   (keyword "[type=\"button\"]")
                   (keyword "[role=\"button\"]")
                   (keyword "[type=\"reset\"]")
                   (keyword "[type=\"submit\"]")
                   (keyword "[type=\"search\"]")
                   (keyword "[hidden]")
                   (keyword "::-webkit-file-upload-button")
                   (keyword "[type=\"search\"]::-webkit-search-decoration")
                   (keyword "button::-moz-focus-inner")
                   (keyword "[type=\"button\"]::-moz-focus-inner")
                   (keyword "[type=\"reset\"]::-moz-focus-inner")
                   (keyword "[type=\"submit\"]::-moz-focus-inner")
                   (keyword "button:-moz-focusring")
                   (keyword "[type=\"button\"]:-moz-focusring")
                   (keyword "[type=\"reset\"]:-moz-focusring")
                   (keyword "[type=\"submit\"]:-moz-focusring")
                   (keyword "[type=\"number\"]::-webkit-inner-spin-button")
                   (keyword "[type=\"number\"]::-webkit-outer-spin-button")
                   (keyword "input::-webkit-input-placeholder")
                   (keyword "textarea::-webkit-input-placeholder")
                   (keyword "input::-moz-placeholder")
                   (keyword "textarea::-moz-placeholder")
                   (keyword "input:-ms-input-placeholder")
                   (keyword "textarea:-ms-input-placeholder")
                   (keyword "input::-ms-input-placeholder")
                   (keyword "textarea::-ms-input-placeholder")
                   (keyword "input::placeholder")
                   (keyword "textarea::placeholder")
                   (keyword "abbr[title]")} (keyword n))
    n (str "." n)))

(defn ->selector [k]
  "Write key as CSS selectors, can be single or a sequence."
  (let [x (fn [n] (-> n name prefix))]
    (-> (if (vector? k)
          (s/join "," (map x k))
          (x k)))))

(defn style->string [smap]
  (reduce
    (fn [output-string [k v]]
      (if (or (map? v) (vector? v))
        (str output-string (->selector k) "{" (style->string v) "}")
        (str output-string (name k) ":" (if (keyword? v)
                                          (name v) v) ";")))
    "" (if (map? smap) smap (partition 2 smap))))

(defn with-responsive-prefix
  "Apply a min-width media query an class prefix to styles e.g md:text-gray-700"
  [smap prefix screen-width]
  (str "@media (min-width: " screen-width "){"
  (style->string
    (reduce (fn [coll [k v]]
              (into coll [(str prefix "\\" k) v]))
            [] (partition 2 smap))) "}"))

(def all (reduce into [normalize base components accessibility transition]))

(defn internal-generate-styles [css-styles css-components-styles]
  (str (style->string css-styles)
       (with-responsive-prefix css-components-styles "sm" "640px")
       (with-responsive-prefix css-components-styles "md" "768px")
       (with-responsive-prefix css-components-styles "lg" "1024px")
       (with-responsive-prefix css-components-styles "xl" "1024px")))

(defn generate-styles [path]
  (spit path (internal-generate-styles all components)))

(defn generate-styles-with
  "Generate Tailwind CSS and append the provided css-file on the end."
  [path css-file]
  (spit path (str (internal-generate-styles all components) (slurp css-file))))

(defn split-tags-and-classes [tags]
  (reduce
    (fn [coll tag]
      (into coll 
            (if (keyword? tag)
              (-> tag
                  name
                  (clojure.string/split #"\.")
                  (#(map keyword %)))
              [tag])))
    [] tags))

;; used-css-classes aren't just classes but 'keywords' like body/html, psedo tags etc
(defn purge-styles [css-styles used-css-classes]
  (let [split-used-css-classes (split-tags-and-classes used-css-classes)]
        (reduce (fn [coll [k v]]
                  (if (some #{k} split-used-css-classes)
                    (into coll [k v])
                    coll))
                [] (partition 2 css-styles))))

(defn all-keywords-in-file [filepath]
  (let [reader (java.io.PushbackReader. (clojure.java.io/reader filepath))
        eof (Object.)]
    (set
      (filter keyword?
              (flatten ;; TODO may have to flatten completely
                (loop [acc []
                       form (read reader false eof)]
                  (if (identical? eof form)
                    acc
                    (recur (conj acc form) (read reader false eof)))))))))

(def default-keywords
  [:html :body :* [:* (keyword "::before") (keyword "::after")]])

(defn all-project-keywords []
  (->> (file-seq (clojure.java.io/file "src"))
       (filter #(.isFile %))
       (filter #(not (clojure.string/ends-with? (.getName %) ".cljc")))
       (#(mapcat all-keywords-in-file %))
       (into default-keywords)))

(defn purge-and-generate-styles [path]
  (spit path (internal-generate-styles
               (purge-styles all (all-project-keywords))
               (purge-styles components (all-project-keywords)))))

(defn purge-and-generate-styles-with [path css-file]
  ;; TODO count how many styles are being generated? at least for debug purposes
  (spit path (str (internal-generate-styles
                    (purge-styles all (all-project-keywords))
                    (purge-styles components (all-project-keywords))) (slurp css-file))))

(defn watch
  "Watch & rebuild styles on file modified, useful when developing to view sites with purged code as you would use in production.
  Also useful for providing the feedback when manipulating classes in Clojure e.g splitting (str \"bg-green-\" v)."
  ([output]
   (watch output {}))
  ([output {:keys [input-file watch-dir]}]
   (let [dir (or watch-dir (System/getProperty "user.dir"))]
     (log/info (str "sail watcher started, monitoring file changes under " dir))
     (dw/watch-dir
       (fn [{:keys [file]}]
         (let [path (.getAbsolutePath file)]
           (when-not (s/includes? path output)
                   (log/info (str "watcher requested style generation: " path))
                   (if input-file
                     (purge-and-generate-styles-with output input-file)
                     (purge-and-generate-styles output))))) (io/file dir)))))
