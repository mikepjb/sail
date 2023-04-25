(ns sail.sandbox
  (:require [goog.dom :as gdom]
            [reagent.core :as r]
            [reagent.dom :as rdom]))

(defonce state (r/atom {}))

(println "Sail Sandbox Environment")

(defn flex-row []
  [:div [:span.font-semibold "flex-row-test"]
   [:div.my-2.flex.flex-row.gap-4
    [:div "item 1"]
    [:div "item 2"]
    [:div "item 3"]]])

(defn flex-col []
  [:div [:span.font-semibold "flex-col-test"]
   [:div.my-2.flex.flex-col.gap-2
    [:div "item 1"]
    [:div "item 2"]
    [:div "item 3"]]])

(defn media-query-test []
  [:div.my-2.flex.flex-col.sm:flex-row.gap-4
   [:div "item 1"]
   [:div "item 2"]
   [:div "item 3"]])

(defn text-sizes []
  [:div.mb-6
   [:div.text-9xl.mb-2 "Text 9xl"]
   [:div.text-5xl.mb-2 "Text 5xl"]
   [:div.text-2xl.mb-2 "Text 2xl"]
   [:div.text-base.mb-2 "Text Base"]
   [:div.text-xs "Text XS"]
   ]
  )

(defn title
  ([label]
   [title {} label])
  ([opts label]
   [:div.mb-4
    [:div.mb-1.uppercase.font-black.text-stone-800
     opts label]
    [:div.h-1.w-16.bg-blue-200 ""]]))

(defn buttons []
  [:div
   [:div.text-xs.italic.text-stone-700.mb-2 "N.B flat hover only works over gradients if you include hover:bg-none to cancel out the applied background-image, maybe this should be included?"]
   [:div.flex.mb-6.gap-4
    [:div.inline-flex.p-2.font-semibold.bg-red-300.text-orange-900.rounded.shadow.shadow-orange-800.hover:bg-red-800.cursor-pointer "standard test"]
    [:div.inline-flex.p-2.font-semibold.bg-gradient-to-b.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800 "gradient test"]
    [:div.inline-flex.p-2.font-semibold.bg-gradient-to-tl.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800 "gradient test 2"]
    [:div.inline-flex.p-2.font-semibold.bg-gradient-to-b.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800.hover:bg-none.hover:bg-green-400 "gradient test with flat hover color"]
    [:div.inline-flex.w-32.p-2.font-semibold.bg-gradient-to-b.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800.hover:from-pink-500.hover:to-yellow-500 "gradient test with gradient hover color"]]])


(defn app [state]
  [:div.m-6.flex.flex-col
   ;; [:div.text-2xl.mb-6.uppercase.font-black.text-stone-800 "Sail Sandbox Environment"]
   [title {:class :text-2xl} "Sail Sandbox Environment"]
   [:div.flex.flex-wrap.gap-4
    [:div
     [title "Font Sizes"]
     [text-sizes]]
    [:div [title "Inputs"]
     [:input.w-4.h-4.accent-blue-500 {:type :checkbox :default-checked true}]
     [:input.w-4.h-4.accent-pink-500 {:type :checkbox :default-checked true}]
     [:input.w-4.h-4.accent-green-500 {:type :checkbox :default-checked true}]]
    [:div [title "Flex Row and Column"]
     [flex-row]
     [flex-col]]
    [:div [title "Gradients"]
     [buttons]]
    [:div [title "Media Queries"]
    [media-query-test]]
    ]
   ])

(rdom/render [app state] (gdom/getElement "app"))
