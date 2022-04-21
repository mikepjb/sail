(ns sail.components
  (:require [sail.color :refer [palette color-class rgba-color-class]]))

;; (defn with-media-query)
(defn with-pseudo-class
  "Set a collection of rules to work for a given pseudo class"
  [class-name css-rules]
  (reduce
    (fn [coll [k v]]
      (into coll [(keyword (str class-name "\\:" (name k) ":" class-name)) v]))
    [] (partition 2 css-rules)))


(def main ;; for lack of a better name..
  [:appearance-none
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
            :border {:border-width "1px"}
            :border-1 {:border-width "1px"}
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
   :flex-col [:-webkit-box-orient "vertical"
              :-webkit-box-direction "normal"
              :flex-direction "column"]
   :flex-col-reverse [:-webkit-box-orient "vertical"
                      :-webkit-box-direction "reverse"
                      :flex-direction "column-reverse"]
   :flex-wrap {:flex-wrap "wrap"}
   :flex-wrap-reverse {:flex-wrap "wrap-reverse"}
   :flex-no-wrap {:flex-wrap "nowrap"}
   :items-start {:-webkit-box-align "start" :align-items "flex-start"}
   :items-end {:-webkit-box-align "end" :align-items "flex-end"}
   :items-center {:-webkit-box-align "center" :align-items "center"}
   :items-baseline {:-webkit-box-align "baseline" :align-items "baseline"}
   :items-stretch {:-webkit-box-align "stretch" :align-items "stretch"}
   :self-auto {:align-self "auto"}
   :self-start {:align-self "flex-start"}
   :self-end {:align-self "flex-end"}
   :self-center {:align-self "center"}
   :self-stretch {:align-self "stretch"}
   :justify-start {:-webkit-box-pack "start" :justify-content "flex-start"}
   :justify-end {:-webkit-box-pack "end" :justify-content "flex-end"}
   :justify-center {:-webkit-box-pack "center" :justify-content "center"}
   :justify-between {:-webkit-box-pack "justify" :justify-content "space-between"}
   :justify-evenly {:-webkit-box-pack "space-evenly" :justify-content "space-evenly"}
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
            (into coll [(keyword (str "leading-" (name k)))
                        {:line-height v}])) [] leading-table))

(defn tracking-class []
  (reduce (fn [coll [k v]]
            (into coll [(keyword (str "tracking-" (name k)))
                        {:letter-spacing v}])) []
          {:tighter "-0.05em"
           :tight "-0.025em"
           :normal "0"
           :wide "0.025em"
           :wider "0.05em"
           :widest "0.1em"}))

(def font
  (reduce into
          [[:font-sans "-apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, \"Noto Sans\", sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\", \"Noto Color Emoji\""
            :font-serif "Georgia, Cambria, \"Times New Roman\", Times, serif"
            :font-mono "Menlo, Monaco, Consolas, \"Liberation Mono\", \"Courier New\", monospace"]
           (weight-class)
           (with-pseudo-class "hover" (weight-class))
           (with-pseudo-class "focus" (weight-class))
           (leading-class)
           (tracking-class)]))

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
   :14 "3.5rem"
   :16 "4rem"
   :20 "5rem"
   :24 "6rem"
   :28 "6rem"
   :32 "8rem"
   :36 "9rem"
   :40 "10rem"
   :44 "11rem"
   :48 "12rem"
   :52 "13rem"
   :56 "14rem"
   :60 "15rem"
   :64 "16rem"
   :72 "18rem"
   :80 "20rem"
   :96 "24rem"
   :auto "auto"
   :px "1px"})

;; TODO does the job but is unwieldy
(defn spacing-class [prefix properties & [property-prefix]]
  (reduce
    (fn [coll [k v]]
      (into coll [(keyword (str prefix "-" (name k)))
                  (into {} (mapv
                             (fn [p]
                               [(keyword p)
                                (if property-prefix (str property-prefix v) v)])
                             (if (vector? properties) properties [properties])
                             ))])) [] spacing-table))

;; N.B these are grouped semantically, vanilla has a different order.
(def spacing
  (reduce into
          [(spacing-class "h" "height")
           [:h-full {:height "100%"}]
           [:h-screen {:height "100vh"}]
           (spacing-class "m" "margin")
           (spacing-class "-m" "margin" "-")
           (spacing-class "my" ["margin-top" "margin-bottom"])
           (spacing-class "mx" ["margin-left" "margin-right"])
           (spacing-class "-my" ["margin-top" "margin-bottom"] "-")
           (spacing-class "-mx" ["margin-left" "margin-right"] "-")
           (spacing-class "mt" "margin-top")
           (spacing-class "mr" "margin-right")
           (spacing-class "ml" "margin-left")
           (spacing-class "mb" "margin-bottom")
           (spacing-class "-mt" "margin-top" "-")
           (spacing-class "-mr" "margin-right" "-")
           (spacing-class "-ml" "margin-left" "-")
           (spacing-class "-mb" "margin-bottom" "-")
           [:max-h-full {:max-height "100%"}
            :max-h-screen {:max-height "100vh"}
            :max-w-xs {:max-width "20rem"}
            :max-w-sm {:max-width "24rem"}
            :max-w-md {:max-width "28rem"}
            :max-w-lg {:max-width "32rem"}
            :max-w-xl {:max-width "36rem"}
            :max-w-2xl {:max-width "42rem"}
            :max-w-3xl {:max-width "48rem"}
            :max-w-4xl {:max-width "56rem"}
            :max-w-5xl {:max-width "64rem"}
            :max-w-6xl {:max-width "72rem"}
            :max-w-full {:max-width "100%"}
            :min-h-0 {:min-height 0}
            :min-h-full {:min-height "100%"}
            :min-h-screen {:min-height "100vh"}
            :min-w-0 {:min-width 0}
            :min-w-full {:min-width "100%"}]
           (spacing-class "p" "padding")
           (spacing-class "py" ["padding-top" "padding-bottom"])
           (spacing-class "px" ["padding-left" "padding-right"])
           (spacing-class "pt" "padding-top")
           (spacing-class "pr" "padding-right")
           (spacing-class "pl" "padding-left")
           (spacing-class "pb" "padding-bottom")
           (spacing-class "w" "width")
           [(keyword "w-1/2") {:width "50%"}
            :w-1-2 {:width "50%"}
            (keyword "w-1/3") {:width "33.333333%"}
            :w-1-3 {:width "33.333333%"}
            (keyword "w-2/3") {:width "66.666667%"}
            :w-2-3 {:width "66.666667%"}
            (keyword "w-1/4") {:width "25%"}
            :w-1-4 {:width "25%"}
            (keyword "w-2/4") {:width "50%"}
            :w-2-4 {:width "50%"}
            (keyword "w-3/4") {:width "75%"}
            :w-3-4 {:width "75%"}
            (keyword "w-1/5") {:width "20%"}
            :w-1-5 {:width "20%"}
            (keyword "w-2/5") {:width "40%"}
            :w-2-5 {:width "40%"}
            (keyword "w-3/5") {:width "60%"}
            :w-3-5 {:width "60%"}
            (keyword "w-4/5") {:width "80%"}
            :w-4-5 {:width "80%"}
            (keyword "w-1/6") {:width "16.666667%"}
            :w-1-6 {:width "16.666667%"}
            (keyword "w-2/6") {:width "33.333333%"}
            :w-2-6 {:width "33.333333%"}
            (keyword "w-3/6") {:width "50%"}
            :w-3-6 {:width "50%"}
            (keyword "w-4/6") {:width "66.666667%"}
            :w-4-6 {:width "66.666667%"}
            (keyword "w-5/6") {:width "83.333333%"}
            :w-5-6 {:width "83.333333%"}
            (keyword "w-1/12") {:width "8.333333%"}
            :w-1-12 {:width "8.333333%"}
            (keyword "w-2/12") {:width "16.666667%"}
            :w-2-12 {:width "16.666667%"}
            (keyword "w-3/12") {:width "25%"}
            :w-3-12 {:width "25%"}
            (keyword "w-4/12") {:width "33.333333%"}
            :w-4-12 {:width "33.333333%"}
            (keyword "w-5/12") {:width "41.666667%"}
            :w-5-12 {:width "41.666667%"}
            (keyword "w-6/12") {:width "50%"}
            :w-6-12 {:width "50%"}
            (keyword "w-7/12") {:width "58.333333%"}
            :w-7-12 {:width "58.333333%"}
            (keyword "w-8/12") {:width "66.666667%"}
            :w-8-12 {:width "66.666667%"}
            (keyword "w-9/12") {:width "75%"}
            :w-9-12 {:width "75%"}
            (keyword "w-10/12") {:width "83.333333%"}
            :w-10-12 {:width "83.333333%"}
            (keyword "w-11/12") {:width "91.666667%"}
            :w-11-12 {:width "91.666667%"}
            :w-full {:width "100%"}
            :w-screen {:width "100vw"}
            :z-0 {:z-index 0}
            :z-10 {:z-index 10}
            :z-20 {:z-index 20}
            :z-30 {:z-index 30}
            :z-40 {:z-index 40}
            :z-50 {:z-index 50}
            :z-auto {:z-index "auto"}
            :smooth-scroll {:scroll-behavior "smooth"}]
           ;; TODO no placeholder for now, I don't use these classes
           ;; placeholder stuff from L5876 until L9592
           [:pointer-events-none {:pointer-events "none"}
            :pointer-events-auto {:pointer-events "auto"}
            :static {:position "static"}
            :fixed {:position "fixed"}
            :absolute {:position "absolute"}
            :relative {:position "relative"}
            :sticky [:position "-webkit-sticky" :position "sticky"]
            :inset-auto {:top "auto" :right "auto" :bottom "auto" :left "auto"}
            :inset-0 {:top 0 :right 0 :bottom 0 :left 0}
            :inset-y-0 {:top 0 :bottom 0}
            :inset-y-auto {:top "auto" :bottom "auto"}
            :inset-x-auto {:right "auto" :left "auto"}
            :top-0 {:top 0}
            :right-0 {:right 0}
            :bottom-0 {:bottom 0}
            :left-0 {:left 0}
            :top-auto {:top "auto"}
            :right-auto {:right "auto"}
            :bottom-auto {:bottom "auto"}
            :left-auto {:left "auto"}
            :resize-none {:resize "none"}
            :resize-y {:resize "vertical"}
            :resize-x {:resize "horizontal"}
            :resize {:resize "both"}]]))

(def opacity
  (reduce
    (fn [coll [k v]]
      (into coll [(str "opacity-" (name k)) {:opacity v}]))
    [] {:0 0 :25 0.25 :50 0.5 :75 0.75 :100 1}))

;; How does Tailwind v3 shadows work with the new color feature?

;; 1. shadow classes e.g shadow-lg has:
;;   a. --tw-shadow with the standard/original rule
;;   b. --tw-shadow-colored with the original rule + color variables
;; 2. there is an additional [:shadow :shadow-lg]] level that actually defines
;; the box-shadow css rule using --tw-shadow
;; 3. IF a shadow color rule e.g shadow-cyan-500-50 is included
;;   a. the rule overwrites --tw-shadow so that the colored rule overwrites the
;;   --tw-shadow rule included by the base class.

;; for now: base shadow is a single class and opacity is default 50 only (until
;; we also implement JIT to avoid dev slowdown)

    

(def base-shadow
  [:shadow     {:--tw-shadow "0 1px 3px 0 rgb(0 0 0 / 0.1), 0 1px 2px -1px rgb(0 0 0 / 0.1)"
                :--tw-shadow-colored "0 1px 3px 0 var(--tw-shadow-color), 0 1px 2px -1px var(--tw-shadow-color)"
                :box-shadow "var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)"}
   :shadow-sm  {:--tw-shadow "0 1px 2px 0 rgb(0 0 0 / 0.05)"
                :--tw-shadow-colored "0 1px 2px 0 var(--tw-shadow-color)"
                :box-shadow "var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)"}
   :shadow-md  {:--tw-shadow "0 4px 6px -1px rgb(0 0 0 / 0.1), 0 2px 4px -2px rgb(0 0 0 / 0.1)"
                :--tw-shadow-colored "0 4px 6px -1px var(--tw-shadow-color), 0 2px 4px -2px var(--tw-shadow-color)"
                :box-shadow "var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)"}
   :shadow-lg  {:--tw-shadow "0 10px 15px -3px rgb(0 0 0 / 0.1), 0 4px 6px -4px rgb(0 0 0 / 0.1)"
                :--tw-shadow-colored "0 10px 15px -3px var(--tw-shadow-color), 0 4px 6px -4px var(--tw-shadow-color)"
                :box-shadow "var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)"}
   :shadow-xl  {:--tw-shadow "0 20px 25px -5px rgb(0 0 0 / 0.1), 0 8px 10px -6px rgb(0 0 0 / 0.1)"
                :--tw-shadow-colored "20px 25px -5px var(--tw-shadow-color), 0 8px 10px -6px var(--tw-shadow-color)"
                :box-shadow "var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)"}
   :shadow-2xl {:--tw-shadow "0 25px 50px -12px rgb(0 0 0 / 0.25)"
                :--tw-shadow-colored "0 25px 50px -12px var(--tw-shadow-color)"
                :box-shadow "var(--tw-ring-offset-shadow, 0 0 #0000), var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow)"}

   :shadow-inner {:box-shadow "inset 0 2px 4px 0 rgba(0, 0, 0, 0.06)"}
   :shadow-none {:box-shadow "none"}])

(def shadow-color (rgba-color-class "shadow" "--tw-shadow" "--tw-shadow-color" 0.5))
;; (take 4 (rgba-color-class "shadow" "--tw-shadow" "--tw-shadow-color" 50))

(def text-style
  [:text-xs {:font-size "0.75rem" :line-height "1rem"}
   :text-sm {:font-size "0.875rem" :line-height "1.25rem"}
   :text-base {:font-size "1rem" :line-height "1.5rem"}
   :text-lg {:font-size "1.125rem" :line-height "1.75rem"}
   :text-xl {:font-size "1.25rem" :line-height "1.75rem"}
   :text-2xl {:font-size "1.5rem" :line-height "2rem"}
   :text-3xl {:font-size "1.875rem" :line-height "2.25rem"}
   :text-4xl {:font-size "2.25rem" :line-height "2.5rem"}
   :text-5xl {:font-size "3rem" :line-height "1"}
   :text-6xl {:font-size "3.75rem" :line-height "1"}
   :text-7xl {:font-size "4.5rem" :line-height "1"}
   :text-8xl {:font-size "6rem" :line-height "1"}
   :text-9xl {:font-size "8rem" :line-height "1"}
   :italic {:font-style "italic"}
   :not-italic {:font-style "normal"}
   :uppercase {:text-transform "uppercase"}
   :lowercase {:text-transform "lowercase"}
   :capitalize {:text-transform "capitalize"}
   :normal-case {:text-transform "none"}
   :underline {:text-decoration "underline"}
   :line-through {:text-decoration "line-through"}
   :no-underline {:text-decoration "none"}
   ])

(defn autoprefix [property value]
  (reduce (fn [coll prefix]
            (into coll {(keyword (str prefix property)) value}))
          {} ["-webkit-" "-moz-" "-ms-" ""]))

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
                spacing
                [:list-inside {:list-style-position "inside"}
                 :list-outside {:list-style-position "outside"}
                 :list-none {:list-style-type "none"}
                 :list-disc {:list-style-type "disc"}
                 :list-decimal {:list-style-type "decimal"}]
                [:object-contain {:-o-object-fit "contain" :object-fit "contain"}
                 :object-cover {:-o-object-fit "cover" :object-fit "cover"}
                 :object-fill {:-o-object-fit "fill" :object-fit "fill"}
                 :object-none {:-o-object-fit "none" :object-fit "none"}
                 :object-scale-down {:-o-object-fit "scale-down" :object-fit "scale-down"}
                 :object-bottom {:-o-object-position "bottom" :object-position "bottom"}
                 :object-center {:-o-object-position "center" :object-position "center"}
                 :object-left {:-o-object-position "left" :object-position "left"}
                 :object-left-bottom {:-o-object-position "left bottom"
                                      :object-position "left bottom"}
                 :object-left-top {:-o-object-position "left top"
                                      :object-position "left top"}
                 :object-right {:-o-object-position "right" :object-position "right"}
                 :object-right-bottom {:-o-object-position "right bottom"
                                      :object-position "right bottom"}
                 :object-right-top {:-o-object-position "right top"
                                      :object-position "right top"}
                 :object-top {:-o-object-position "top" :object-position "top"}]
                 opacity
                 (with-pseudo-class "hover" opacity)
                 (with-pseudo-class "focus" opacity)
                 [:outline-none {:outline 0}
                  :focus:outline:focus {:outline 0}
                  :overflow-auto {:overflow "auto"}
                  :overflow-hidden {:overflow "hidden"}
                  :overflow-visible {:overflow "visible"}
                  :overflow-scroll {:overflow "scroll"}
                  :overflow-x-auto {:overflow-x "auto"}
                  :overflow-y-auto {:overflow-y "auto"}
                  :overflow-x-hidden {:overflow-x "hidden"}
                  :overflow-y-hidden {:overflow-y "hidden"}
                  :overflow-x-visible {:overflow-x "visible"}
                  :overflow-y-visible {:overflow-y "visible"}
                  :overflow-x-scroll {:overflow-x "scroll"}
                  :overflow-y-scroll {:overflow-y "scroll"}
                  :scrolling-touch {:-webkit-overflow-scrolling "touch"}
                  :scrolling-auto {:-webkit-overflow-scrolling "auto"}]
                 base-shadow
                 shadow-color
                 (with-pseudo-class "hover" base-shadow)
                 (with-pseudo-class "focus" base-shadow)
                 [:fill-current {:fill "currentColor"}
                  :stroke-current {:stroke "currentColor"}
                  :table-auto {:table-layout "auto"}
                  :table-fixed {:table-layout "fixed"}
                  :text-left {:text-align "left"}
                  :text-center {:text-align "center"}
                  :text-right {:text-align "right"}
                  :text-justify {:text-align "justify"}
                  :text-transparent {:color "transparent"}]
                 (color-class "text" "color")
                 (with-pseudo-class "hover" (color-class "text" "color"))
                 (with-pseudo-class "focus" (color-class "text" "color"))
                 text-style
                 (with-pseudo-class "hover" text-style)
                 (with-pseudo-class "focus" text-style)
                 [:antialiased {:-webkit-font-smoothing "antialiased"
                                :-moz-osx-font-smoothing "grayscale"}
                  :subpixel-antialiased {:-webkit-font-smoothing "auto"
                                         :-moz-osx-font-smoothing "auto"}
                  :select-none (autoprefix "user-select" "none")
                  :select-text (autoprefix "user-select" "text")
                  :select-all (autoprefix "user-select" "all")
                  :select-auto (autoprefix "user-select" "auto")
                  :align-baseline {:vertical-align "baseline"}
                  :align-top {:vertical-align "top"}
                  :align-middle {:vertical-align "middle"}
                  :align-bottom {:vertical-align "bottom"}
                  :align-text-top {:vertical-align "text-top"}
                  :align-text-bottom {:vertical-align "text-bottom"}
                  :visible {:visibility "visible"}
                  :invisible {:visibility "hidden"}
                  :whitespace-normal {:white-space "normal"}
                  :whitespace-no-wrap {:white-space "nowrap"}
                  :whitespace-pre {:white-space "pre"}
                  :whitespace-pre-line {:white-space "pre-line"}
                  :whitespace-pre-wrap {:white-space "pre-wrap"}
                  :break-normal {:overflow-wrap "normal" :word-break "normal"}
                  :break-words {:overflow-wrap "break-word"}
                  :break-all {:overflow-wrap "break-all"}
                  :truncate {:overflow "hidden" :text-overflow "ellipsis" :white-space "nowrap"}
                 ]]))
