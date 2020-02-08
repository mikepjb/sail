(ns sail.components
  (:require [sail.color :refer [palette color-class]]))

(def main ;; for lack of a better name..
  [;; TODO skipped L602 .container and media queries 
   ;; TODO skipped sr-only
   :appearance-none
   {:-webkit-appearance "none"
    :-moz-appearance "none"
    :appearance "none"}

   :bg-fixed {:background-attachment "fixed"}
   :bg-local {:background-attachment "local"}
   :bg-scroll {:background-attachment "scroll"}
   :bg-transparent {:background-attachment "transparent"}
   ])

(def components
  (into main
        (color-class "bg" "background-color")))

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
