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

(def background
  [:bg-bottom {:background-position "bottom"}
   :bg-center {:background-position "center"}
   :bg-left {:background-position "left"}
   :bg-left-bottom {:background-position "left bottom"}
   :bg-left-top {:background-position "left top"}
   :bg-right {:background-position "right"}
   :bg-right-bottom {:background-position "right bottom"}
   :bg-right-top {:background-position "right top"}
   :bg-top {:background-position "top"}
   :bg-repeat {:background-repeat "repeat"}
   :bg-no-repeat {:background-repeat "no-repeat"}
   :bg-repeat-x {:background-repeat "repeat-x"}
   :bg-repeat-y {:background-repeat "repeat-y"}
   :bg-repeat-round {:background-repeat "round"}
   :bg-repeat-space {:background-repeat "space"}
   :bg-auto {:background-size "auto"}
   :bg-cover {:background-size "cover"}
   :bg-contain {:background-size "contain"}])

(def border
  (reduce into
          [:border-collapse {:border-collapse "collapse"}
           :border-seperate {:border-collapse "seperate"}
           :border-transparent {:border-collapse "transparent"}]
          (color-class "border" "border-color")
          (with-pseudo-class "hover" (color-class "border" "border-color"))
          (with-pseudo-class "focus" (color-class "border" "border-color"))))

;; (defn with-media-query)
(defn with-pseudo-class
  "Set a collection of rules to work for a given pseudo class"
  [class-name css-rules]
  (reduce
    (fn [coll [k v]]
      (into coll [(keyword (str class-name ":" (name k) ":" class-name)) v]))
    [] (partition 2 css-rules)))

(def components
  (reduce into [main
                (color-class "bg" "background-color")
                (with-pseudo-class "hover" (color-class "bg" "background-color"))
                (with-pseudo-class "focus" (color-class "bg" "background-color"))
                ;; TODO active is disabled by default on vanilla Tailwind
                ;; (with-pseudo-class "active" (color-class "bg" "background-color"))
                background
                border
                ]))

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
