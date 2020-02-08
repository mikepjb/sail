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
          (with-pseudo-class "focus" (color-class "border" "border-color"))
          [:rounded-none {:border-radius "none"}
           ;; TODO rounded-sm is based on sm being a particular value
           ;; treat like color with palette?
           :rounded-sm {:border-radius "0.125rem"}
           :rounded {:border-radius "0.25rem"}
           :rounded-lg {:border-radius "0.5rem"}
           :rounded-full {:border-radius "9999px"}
           :rounded-t-none {:border-top-left-radius 0
                            :border-top-right-radius 0}
           :rounded-b-none {:border-bottom-left-radius 0
                            :border-bottom-right-radius 0}
           :rounded-l-none {:border-top-left-radius 0
                            :border-bottom-left-radius 0}
           :rounded-r-none {:border-top-right-radius 0
                            :border-bottom-right-radius 0}
           :rounded-t-sm {:border-top-left-radius "0.125rem"
                          :border-top-right-radius "0.125rem"}
           :rounded-b-sm {:border-bottom-left-radius "0.125rem"
                          :border-bottom-right-radius "0.125rem"}
           :rounded-l-sm {:border-top-left-radius "0.125rem"
                          :border-bottom-left-radius "0.125rem"}
           :rounded-r-sm {:border-top-right-radius "0.125rem"
                          :border-bottom-right-radius "0.125rem"}
           :rounded-t {:border-top-left-radius "0.25rem"
                       :border-top-right-radius "0.25rem"}
           :rounded-b {:border-bottom-left-radius "0.25rem"
                       :border-bottom-right-radius "0.25rem"}
           :rounded-l {:border-top-left-radius "0.25rem"
                       :border-bottom-left-radius "0.25rem"}
           :rounded-r {:border-top-right-radius "0.25rem"
                       :border-bottom-right-radius "0.25rem"}
           :rounded-t-lg {:border-top-left-radius "0.5rem"
                          :border-top-right-radius "0.5rem"}
           :rounded-b-lg {:border-bottom-left-radius "0.5rem"
                          :border-bottom-right-radius "0.5rem"}
           :rounded-l-lg {:border-top-left-radius "0.5rem"
                          :border-bottom-left-radius "0.5rem"}
           :rounded-r-lg {:border-top-right-radius "0.5rem"
                          :border-bottom-right-radius "0.5rem"}
           :rounded-t-full {:border-top-left-radius "9999px"
                            :border-top-right-radius "9999px"}
           :rounded-b-full {:border-bottom-left-radius "9999px"
                            :border-bottom-right-radius "9999px"}
           :rounded-l-full {:border-top-left-radius "9999px"
                            :border-bottom-left-radius "9999px"}
           :rounded-r-full {:border-top-right-radius "9999px"
                            :border-bottom-right-radius "9999px"}
           :rounded-tl-none {:border-top-left-radius "0"}
           :rounded-tr-none {:border-top-right-radius "0"}
           :rounded-bl-none {:border-bottom-left-radius "0"}
           :rounded-br-none {:border-bottom-right-radius "0"}
           :rounded-tl-sm {:border-top-left-radius "0.125rem"}
           :rounded-tr-sm {:border-top-right-radius "0.125rem"}
           :rounded-bl-sm {:border-bottom-left-radius "0.125rem"}
           :rounded-br-sm {:border-bottom-right-radius "0.125rem"}
           :rounded-tl {:border-top-left-radius "0.25rem"}
           :rounded-tr {:border-top-right-radius "0.25rem"}
           :rounded-bl {:border-bottom-left-radius "0.25rem"}
           :rounded-br {:border-bottom-right-radius "0.25rem"}
           :rounded-tl-lg {:border-top-left-radius "0.5rem"}
           :rounded-tr-lg {:border-top-right-radius "0.5rem"}
           :rounded-bl-lg {:border-bottom-left-radius "0.5rem"}
           :rounded-br-lg {:border-bottom-right-radius "0.5rem"}
           :rounded-tl-full {:border-top-left-radius "9999px"}
           :rounded-tr-full {:border-top-right-radius "9999px"}
           :rounded-bl-full {:border-bottom-left-radius "9999px"}
           :rounded-br-full {:border-bottom-right-radius "9999px"}
           :border-solid {:border-style "solid"}
           :border-dashed {:border-style "dashed"}
           :border-dotted {:border-style "dotted"}
           :border-double {:border-style "double"}
           :border-none {:border-style "none"}
           :border-0 {:border-width "0"}
           :border-2 {:border-width "2px"}
           :border-4 {:border-width "4px"}
           :border-8 {:border-width "8px"}
           :border-t-0 {:border-top-width "0"}
           :border-r-0 {:border-right-width "0"}
           :border-b-0 {:border-bottom-width "0"}
           :border-l-0 {:border-left-width "0"}
           :border-t-2 {:border-top-width "2px"}
           :border-r-2 {:border-right-width "2px"}
           :border-b-2 {:border-bottom-width "2px"}
           :border-l-2 {:border-left-width "2px"}
           :border-t-4 {:border-top-width "4px"}
           :border-r-4 {:border-right-width "4px"}
           :border-b-4 {:border-bottom-width "4px"}
           :border-l-4 {:border-left-width "4px"}
           :border-t-8 {:border-top-width "8px"}
           :border-r-8 {:border-right-width "8px"}
           :border-b-8 {:border-bottom-width "8px"}
           :border-l-8 {:border-left-width "8px"}
           :border-t {:border-top-width "1px"}
           :border-r {:border-right-width "1px"}
           :border-b {:border-bottom-width "1px"}
           :border-l {:border-left-width "1px"}]))

(def cursor
  [:cursor-auto {:cursor "auto"}
   :cursor-default {:cursor "default"}
   :cursor-pointer {:cursor "pointer"}
   :cursor-wait {:cursor "wait"}
   :cursor-text {:cursor "text"}
   :cursor-move {:cursor "move"}
   :cursor-not-allowed {:cursor "not-allowed"}])

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
                cursor
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
