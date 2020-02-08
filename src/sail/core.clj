(ns sail.core
  (:require [clojure.string]
            [sail.normalize :refer [normalize]]))

(defn prefix
  "Include . for class names, ignore for reserved words like 'html'."
  [n]
  ;; TODO generate these definitions based on the normalize array map,
  ;; this is PRETTY long and you will need to maintain it otherwise.
  (if (contains? #{:html :body :main :h1 :h2 :h3 :h4 :h5 :h6 
                   :section :nav :header :footer :hr :pre :a
                   :b :strong :code :kbd :samp :small :sub :sup :img
                   :button :input :optgroup :select :textarea
                   :fieldSet :legend :progress :details :summary
                   :template
                   (keyword "[type=\"checkbox\"]")
                   (keyword "[type=\"radio\"]")
                   (keyword "[type=\"button\"]")
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
      (if (map? v)
        (str output-string (->selector k) "{" (style->string v) "}")
        (str output-string (name k) ":" v ";")))
    "" smap))

(style->string normalize)

(defn generate-styles []
  (spit "generated-style.css" (style->string normalize)))

(generate-styles)
