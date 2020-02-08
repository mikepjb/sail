(ns sail.core)

(def sample-style-map
  {:html
   {:line-height "1.15"
    :-webkit-text-size-adjust "100%"}})

(defn style->string [smap]
    (reduce
      (fn [output-string [k v]]
        (if (string? v)
          (str output-string (name k) ":" v ";")
          (str output-string "." (name k) "{" (style->string v) "}"))) 
      "" smap))

(def sample-output
  ".m-2{margin: 0.25rem;}")

(defn generate-styles []
  (spit "generated-style.css" sample-output))

;; (generate-styles)

;; npm view normalize.css version == 8.0.1
;; npm view tailwindcss version == 1.2.0
