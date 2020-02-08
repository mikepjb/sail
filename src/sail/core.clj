(ns sail.core)

(def sample-style-map
  {:html
   {:line-height "1.15"
    :-webkit-text-size-adjust "100%"}})

(defn prefix
  "include . for class names, ignore for reserved words like 'html'"
  [n]
  (if (contains? #{:html :body :main :h1 :h2 :h3 :h4 :h5 :h6 
                   :section :nav :header :footer :hr} (keyword n))
    n (str "." n)))

(defn style->string [smap]
  (reduce
    (fn [output-string [k v]]
      (if (map? v)
        (str output-string (-> k name prefix) "{" (style->string v) "}")
        (str output-string (name k) ":" v ";"))) 
    "" smap))

(def sample-output
  ".m-2{margin: 0.25rem;}")

(def normalize
  "transcribed from github.com/necolas/normalize.css, retaining MIT license"
  {:html
   {;; Correct the line height in all browsers.
    :line-height 1.15
    ;; Prevent adjustments of font size after orientation changes in iOS.
    :-webkit-text-size-adjust "100%"}

   ;; Remove the margin in all browsers.
   :body {:margin 0}

   ;; Render the `main` element consistently in IE.
   :main {:display "block"}

   ;; Correct the font size and margin on `h1` elements within `section` and
   ;; `article` contexts in Chrome, Firefox, and Safari.
   :h1 {:font-size "2em"
        :margin "0.67em 0"}

   :hr {;; Add the correct box sizing in Firefox.
        :box-sizing "content-box"
        :height 0
        ;; Show the overflow in Edge and IE.
        :overflow "visible"
        }
   })

(style->string normalize)

(defn generate-styles []
  (spit "generated-style.css" sample-output))

;; (generate-styles)

;; npm view normalize.css version == 8.0.1
;; npm view tailwindcss version == 1.2.0
