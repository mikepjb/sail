(ns sail.tailwind
  (:require [sail.color :refer [palette color-class]]))

(def custom-reset
  (array-map
    :html {;; Use the system font stack as a sane default.
           :font-family "-apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, \"Noto Sans\", sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\", \"Noto Color Emoji\""
           ;; Use Tailwind's default "normal" line-height so the user isn't forced
           ;; to override it to ensure consistency even when using the default theme.
           :line-height 1.5}
    
    ;; Allow adding a border to an element by just adding a border-width.
    [:* (keyword "*::before") (keyword "*::after")] {:border-width 0 :border-style "solid" :border-color (:gray-300 palette)}

    ;; Ensure horizontal rules are visible by default
    :hr {:border-top-width "1px"}

    ;; TODO Remove the border-style: none reset from Normalize
    ;; Undo the border-style: none reset for images
    :img {:border-style "solid"}

    :textarea {:resize "vertical"}

    ;; when does reset finish?
    ))

;; https://clojureverse.org/t/list-all-unique-keywords-in-current-project/4024/5
;; loads all keywords
#_(let [f (.getDeclaredField clojure.lang.Keyword "table")]
    (.setAccessible f true)
    (map #(.get %) (vals (.get f nil))))

;; stopped at L487.. looks like the work of autoprefixer, I'd like to
;; abstract this work here too to keep things DRY.

;; TODO fill in the gap ...

;; bg- begins @ L682

;; (color-class "bg" "background-color")
;; (color-class "hover:bg" "background-color") ;; TODO missing :hover suffix
;; same for focus
;; L1800 positioning
;; L1890 border color
;; (color-class "border" "border-color")
;; hover + focus
;; L3000 rounded/border work.
;; L3300 cursors.
;; L3350 display stuff block/inline/flex etc
;; makes an interesting case for autoprefixer - value based not property based
;; as I'm used to seeing.
;; .flex {
;;   display: -webkit-box;
;;   display: flex;
;; }
;; (color-class "text" "color")


;; (map (fn [ck] (str ".bg-" (name ck) "{" "background-color:" (get palette ck) ";}"))
;;   [:white :black :gray-100 :gray-200])

(def tailwind custom-reset)
