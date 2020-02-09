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
          [[:border-collapse {:border-collapse "collapse"}
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
            :border-l {:border-left-width "1px"}]]))

(def cursor
  [:cursor-auto {:cursor "auto"}
   :cursor-default {:cursor "default"}
   :cursor-pointer {:cursor "pointer"}
   :cursor-wait {:cursor "wait"}
   :cursor-text {:cursor "text"}
   :cursor-move {:cursor "move"}
   :cursor-not-allowed {:cursor "not-allowed"}])

(def display
  [:block {:display "block"}
   :inline-block {:display "inline-block"}
   :inline {:display "inline"}
   :flex [:display "-webkit-box" :display "flex"]
   :inline-flex [:display "-webkit-inline-box" :display "inline-flex"]
   :table {:display "table"}
   :table-row {:display "table-row"}
   :table-cell {:display "table-cell"}
   :hidden {:display "none"}
   :flex-row [:-webkit-box-orient "horizontal"
              :-webkit-box-direction "normal"
              :flex-direction "row"]
   :flex-row-reverse [:-webkit-box-orient "horizontal"
                      :-webkit-box-direction "reverse"
                      :flex-direction "row-reverse"]
   :flex-col [:-webkit-box-orient "horizontal"
              :-webkit-box-direction "normal"
              :flex-direction "column"]
   :flex-col-reverse [:-webkit-box-orient "horizontal"
                      :-webkit-box-direction "reverse"
                      :flex-direction "column-reverse"]
   :flex-wrap {:flex-wrap "wrap"}
   :flex-wrap-reverse {:flex-wrap "wrap-reverse"}
   :flex-no-wrap {:flex-wrap "nowrap"}
   :items-start {:-webkit-box-align "start" :align-items "flex-start"}
   :items-end {:-webkit-box-align "end" :align-items "flex-end"}
   :items-center {:-webkit-box-align "center" :align-items "flex-center"}
   :items-baseline {:-webkit-box-align "baseline" :align-items "flex-baseline"}
   :items-stretch {:-webkit-box-align "stretch" :align-items "flex-stretch"}
   :self-auto {:align-self "auto"}
   :self-start {:align-self "flex-start"}
   :self-end {:align-self "flex-end"}
   :self-center {:align-self "center"}
   :self-stretch {:align-self "stretch"}
   :justify-start {:-webkit-box-pack "start" :justify-content "flex-start"}
   :justify-end {:-webkit-box-pack "end" :justify-content "flex-end"}
   :justify-center {:-webkit-box-pack "center" :justify-content "center"}
   :justify-between {:-webkit-box-pack "justify" :justify-content "space-between"}
   :justify-around {:justify-content "space-around"}
   :content-center {:align-content "center"}
   :content-start {:align-content "flex-start"}
   :content-end {:align-content "flex-end"}
   :content-between {:align-content "space-between"}
   :content-around {:align-content "space-around"}
   :flex-1 [:-webkit-box-flex 1 :flex "1 1 0%"]
   :flex-auto [:-webkit-box-flex 1 :flex "1 1 auto"]
   :flex-initial [:-webkit-box-flex 0 :flex "0 1 auto"]
   :flex-none [:-webkit-box-flex 0 :flex "none"]
   :flex-grow-0 [:-webkit-box-flex 0 :flex 0]
   :flex-grow [:-webkit-box-flex 1 :flex 1]
   :flex-shrink-0 {:flex-shrink 0}
   :flex-shrink {:flex-shrink 1}
   :order-1 {:-webkit-box-ordinal-group 2 :order 1}
   :order-2 {:-webkit-box-ordinal-group 3 :order 2}
   :order-3 {:-webkit-box-ordinal-group 4 :order 3}
   :order-4 {:-webkit-box-ordinal-group 5 :order 4}
   :order-5 {:-webkit-box-ordinal-group 6 :order 5}
   :order-6 {:-webkit-box-ordinal-group 7 :order 6}
   :order-7 {:-webkit-box-ordinal-group 8 :order 7}
   :order-8 {:-webkit-box-ordinal-group 9 :order 8}
   :order-9 {:-webkit-box-ordinal-group 10 :order 9}
   :order-10 {:-webkit-box-ordinal-group 11 :order 10}
   :order-11 {:-webkit-box-ordinal-group 12 :order 11}
   :order-12 {:-webkit-box-ordinal-group 13 :order 12}
   :order-first {:-webkit-box-ordinal-group -9998 :order -9999}
   :order-last {:-webkit-box-ordinal-group 10000 :order 9999}
   :order-none {:-webkit-box-ordinal-group 1 :order 0}
   :float-right {:float "right"}
   :float-left {:float "left"}
   :float-none {:float "none"}
   :clearfix:after {:content "\"\"" :display "table" :clear "both"}])

(def weight-table
  {:hairline 100
   :thin 200
   :light 300
   :normal 400
   :medium 500
   :semibold 600
   :bold 700
   :extrabold 800
   :black 900})

(defn weight-class []
  (reduce (fn [coll [k v]]
            (into coll [(keyword (str "font-" (name k)))
                        {:font-weight v}])) [] weight-table))

(def leading-table
  {:none 1
   :tight 1.25
   :snug 1.375
   :normal 1.5
   :relaxed 1.625
   :loose 2})

(defn leading-class []
  (reduce (fn [coll [k v]]
            (into coll [(keyword (str "font-" (name k)))
                        {:line-height v}])) [] leading-table))

(def font
  (reduce into
          [[:font-sans "-apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, \"Noto Sans\", sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\", \"Noto Color Emoji\""
            :font-serif "Georgia, Cambria, \"Times New Roman\", Times, serif"
            :font-mono "Menlo, Monaco, Consolas, \"Liberation Mono\", \"Courier New\", monospace"]
           (weight-class)
           (with-pseudo-class "hover" (weight-class))
           (with-pseudo-class "focus" (weight-class))
           (leading-class)]))

;; (defn with-media-query)
(defn with-pseudo-class
  "Set a collection of rules to work for a given pseudo class"
  [class-name css-rules]
  (reduce
    (fn [coll [k v]]
      (into coll [(keyword (str class-name ":" (name k) ":" class-name)) v]))
    [] (partition 2 css-rules)))

(def spacing-table
  {:0 "0"
   :1 "0.25rem"
   :2 "0.5rem"
   :3 "0.75rem"
   :4 "1rem"
   :5 "1.25rem"
   :6 "1.5rem"
   :8 "2rem"
   :10 "2.5rem"
   :12 "3rem"
   :16 "4rem"
   :20 "5rem"
   :24 "6rem"
   :32 "8rem"
   :40 "10rem"
   :48 "12rem"
   :56 "14rem"
   :64 "16rem"
   :auto "auto"
   :px "1px"})

(defn spacing-class [prefix property]
  (reduce (fn [coll [k v]]
            (into coll [(keyword (str prefix "-" (name k)))
                        {(keyword property) v}])) [] spacing-table))

(def spacing
  (reduce into
          [(spacing-class "h" "height")
           [:h-full {:height "100%"}]
           [:h-screen {:height "100vh"}]
           ]))

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
                display
                font
                [:list-inside {:list-style-position "inside"}
                 :list-outside {:list-style-position "outside"}
                 :list-none {:list-style-type "none"}
                 :list-disc {:list-style-type "disc"}
                 :list-decimal {:list-style-type "decimal"}]
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
