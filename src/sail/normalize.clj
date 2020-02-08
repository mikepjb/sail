(ns sail.normalize)

(def normalize
  "Transcribed from github.com/necolas/normalize.css, retaining MIT license."
  [
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
    {;; Change the font styles in all browsers.
     :font-family "inherit"
     :font-size "100%"
     :line-height 1.15
     ;; Remove the margin in Firefox and Safari.
     :margin 0}

    ;; Show the overflow in IE/Edge.
    [:button :input] {:overflow "visible"}

    ;; Remove the inheritance of text transform in Edge, Firefox and IE.
    [:button :select] {:text-transform "none"}

    ;; Correct the inability to style clickable types in iOS and Safari.
    [:button
     (keyword "[type=\"button\"]")
     (keyword "[type=\"reset\"]")
     (keyword "[type=\"submit\"]")] {:-webkit-appearance "button"}

    ;; Remove the inner border and padding in Firefox.
    [(keyword "button::-moz-focus-inner")
     (keyword "[type=\"button\"]::-moz-focus-inner")
     (keyword "[type=\"reset\"]::-moz-focus-inner")
     (keyword "[type=\"submit\"]::-moz-focus-inner")] {:border-style "none" :padding 0}

    ;; Restore the focus styles unset by the previous rule.
    [(keyword "button:-moz-focusring")
     (keyword "[type=\"button\"]:-moz-focusring")
     (keyword "[type=\"reset\"]:-moz-focusring")
     (keyword "[type=\"submit\"]:-moz-focusring")] {:outline "1px dotted ButtonText"}

    ;; Correct the padding in Firefox.
    :fieldSet {:padding "0.35em 0.75em 0.625em"}

    :legend {;; Correct the text wrapping in Edge and IE.
             :box-sizing "border-box"
             :display "table"
             :max-width "100%"
             :white-space "normal"

             ;; Correct the color inheritance from `fieldset` elements in IE.
             :color "inherit"
             ;; Remove the padding so developers are not caught out when they
             ;; zero out `fieldset` elements in all browsers.
             :padding 0}

    ;; Add the correct vertical alignment in Chrome, Firefox, and Opera.
    :progress {:vertical-align "baseline"}

    ;; Remove the default vertical scrollbar in IE 10+.
    :textarea {:overflow "auto"}

    [(keyword "[type=\"checkbox\"]")
     (keyword "[type=\"radio\"]")]
    {;; Add the correct box sizing in IE 10.
     :box-sizing "border-box"
     ;; Remove the padding in IE 10.
     :padding 0}

    ;; Correct the cursor style of increment and decrement buttons in Chrome.
    [(keyword "[type=\"number\"]::-webkit-inner-spin-button")
     (keyword "[type=\"number\"]::-webkit-outer-spin-button")] {:height "auto"}

    (keyword "[type=\"search\"]")
    {;; Correct the odd appearance in Chrome and Safari.
     :-webkit-appearance "textfield"
     ;; Correct the outline style in Safari.
     :outline-offset "-2px"}

    ;; Remove the inner padding in Chrome and Safari on macOS.
    (keyword "[type=\"search\"]::-webkit-search-decoration") {:-webkit-appearance "none"}

    (keyword "::-webkit-file-upload-button")
    {;; Correct the inability to style clickable types in iOS and Safari.
     :-webkit-appearance "button"
     ;; Change font properties to `inherit` in Safari.
     :font "inherit"}

    ;; Add the correct display in Edge, IE 10+, and Firefox.
    :details {:display "block"}

    ;; Add the correct display in all browsers.
    :summary {:display "list-item"}

    ;; Add the correct display in IE 10+.
    :template {:display "none"}

    ;; Add the correct display in IE 10.
    (keyword "[hidden]")  {:display "none"}])

