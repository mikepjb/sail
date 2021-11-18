(ns sail.core
  (:require [clojure.string]
            [sail.normalize :refer [normalize]]
            [sail.base :refer [base]]
            [sail.components :refer [components]]
            [sail.accessibility :refer [accessibility]]))

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
    (if (vector? k)
      (clojure.string/join "," (map x k))
      (x k))))

(defn style->string [smap]
  (reduce
    (fn [output-string [k v]]
      (if (or (map? v) (vector? v))
        (str output-string (->selector k) "{" (style->string v) "}")
        (str output-string (name k) ":" v ";")))
    "" (if (map? smap) smap (partition 2 smap))))

(defn with-responsive-prefix
  "Apply a min-width media query an class prefix to styles e.g md:text-gray-700"
  [smap prefix screen-width]
  (str "@media (min-width: " screen-width "){"
  (style->string
    (reduce (fn [coll [k v]]
              (into coll [(str prefix k) v]))
            [] (partition 2 smap))) "}"))

(def all (reduce into [normalize base components accessibility]))

(defn generate-styles [path]
  (spit path
        (str (style->string all)
             (with-responsive-prefix components "sm" "640px")
             (with-responsive-prefix components "md" "768px")
             (with-responsive-prefix components "sm" "1024px")
             (with-responsive-prefix components "sm" "1024px"))))

;; (generate-styles "styles.gen.css")

;; TODO use this for dead code elimination
;; https://clojureverse.org/t/list-all-unique-keywords-in-current-project/4024/5
;; loads all keywords
;; need to:
;;   - find html keyword prefixed keywords e.g :div.bg-gray-300.text-gray-900
;;   - split those keywords by . -> [:bg-gray-300 :text-gray-900]
;;   - filter out the keywords that don't match from 'all'.
(defn all-project-keywords []
  "Traverses project source code returning all keywords (incl. 3rd party code).
  This is important so we can only include tailwind classes that have been used."
  (let [f (.getDeclaredField clojure.lang.Keyword "table")]
    (.setAccessible f true)
    (map #(.get %) (vals (.get f nil)))))

