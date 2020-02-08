(ns sail.core
  (:require [clojure.string]
            [sail.normalize :refer [normalize]]))

(defn prefix
  "Include . for class names, ignore for reserved words like 'html'."
  [n]
  (if (contains? #{:html :body :main :h1 :h2 :h3 :h4 :h5 :h6 
                   :section :nav :header :footer :hr :pre :a
                   :b :strong :code :kbd :samp :small :sup :img
                   :button :input :optgroup :select :textarea
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
