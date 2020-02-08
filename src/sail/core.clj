(ns sail.core)

(defn prefix
  "include . for class names, ignore for reserved words like 'html'"
  [n]
  (if (contains? #{:html :body :main :h1 :h2 :h3 :h4 :h5 :h6 
                   :section :nav :header :footer :hr :pre :a
                   :b :strong
                   (keyword "abbr[title]")} (keyword n))
    n (str "." n)))

(defn style->string [smap]
  (reduce
    (fn [output-string [k v]]
      (if (map? v)
        (str output-string (-> k name prefix) "{" (style->string v) "}")

        ;; -> if (vec? k) then do seq the value
        (str output-string (name k) ":" v ";")
        ))
    "" smap))

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
        :overflow "visible"}

   :pre {;; Correct the inheritance and scaling of font size in all browsers.
         :font-family "monospace, monospace"
         ;; Correct the odd `em` font sizing in all browsers.
         :font-size "1em"}

   ;; Remove the gray background on active links in IE 10.
   :a {:background-color "transparent"}

   "abbr[title]" {;; Remove the bottom border in Chrome 57-
                  :border-bottom "none"
                  ;; Add the correct text decoration in Chrome, Edge, IE, Opera, and Safari.
                  ;; TODO you can't have duplicate keys in a map, I didn't know
                  ;; this was a thing in CSS. Is it?
                  ;; :text-decoration "underline"
                  :text-decoration "underline dotted"
                  }

   ;; Add the correct font weight in Chrome, Edge, and Safari.
   [:b :strong] {:font-weight "bolder"}
   })

;; (style->string normalize)

(defn generate-styles []
  (spit "generated-style.css" (style->string normalize)))

;; (generate-styles)
