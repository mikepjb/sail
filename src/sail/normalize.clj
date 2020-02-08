(ns sail.normalize)

(def normalize
  "Transcribed from github.com/necolas/normalize.css, retaining MIT license."
  (array-map
    :html
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
    ;; TODO adding in this rule seems to flip the entire printed CSS string..
    ;; how?
    [:b :strong] {:font-weight "bolder"}

    [:code :kbd :samp] {;; Correct the inheritance and scaling of font size in all browsers.
                        :font-family "monospace, monospace"
                        ;; Correct the odd `em` font sizing in all browsers.
                        :font-size "1em"}

    ;; Add the correct font size in all browsers.
    :small {:font-size "80%"}

    ;; Prevent `sub` and `sup` elements from affecting the line height in all browsers.
    [:sub :sup] {:font-size "75%" :line-height 0 :position "relative" :vertical-align "baseline"}
    :sub {:bottom "-0.25em"}
    :sup {:top "-0.5em"}

    ;; Remove the border on images inside links in IE 10.
    :img {:border-style "none"}

    [:button :input :optgroup :select :textarea]
    ;; Change the font styles in all browsers.
    {:font-family "inherit"
     :font-size "100%"
     :line-height 1.15
     :margin 0}
    ))
