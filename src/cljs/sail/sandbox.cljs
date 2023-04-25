(ns sail.sandbox
  (:require [goog.dom :as gdom]
            [reagent.core :as r]
            [reagent.dom :as rdom]))

(defonce state (r/atom {}))

(println "Sail Sandbox Environment")

(defn flex-row []
  [:div [:span.font-semibold "flex-row-test"]
   [:div.my-2.flex.flex-row
    [:div "item 1"]
    [:div "item 2"]
    [:div "item 3"]]])

(defn flex-col []
  [:div [:span.font-semibold "flex-col-test"]
   [:div.my-2.flex.flex-col
    [:div "item 1"]
    [:div "item 2"]
    [:div "item 3"]]])

(defn media-query-test []
  [:div [:span.font-semibold "media-query flex-row/col"]
   [:div.my-2.flex.flex-col.sm:flex-row
    [:div "item 1"]
    [:div "item 2"]
    [:div "item 3"]]])

(defn text-sizes []
  [:div.mb-6
   [:div.text-9xl.mb-2 "Text 9xl"]
   [:div.text-5xl.mb-2 "Text 5xl"]
   [:div.text-2xl.mb-2 "Text 2xl"]
   [:div.text-base.mb-2 "Text Base"]
   [:div.text-xs "Text XS"]
   ]
  )

(defn buttons []
  [:div
   [:div.text-xs.italic.text-stone-700.mb-2 "N.B flat hover only works over gradients if you include hover:bg-none to cancel out the applied background-image, maybe this should be included?"]
   [:div.flex.mb-6.space-between
    [:div.inline-flex.p-2.font-semibold.bg-red-300.text-orange-900.rounded.shadow.shadow-orange-800.hover:bg-red-800.cursor-pointer "standard test"]
    [:div.inline-flex.p-2.font-semibold.bg-gradient-to-b.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800 "gradient test"]
    [:div.inline-flex.p-2.font-semibold.bg-gradient-to-tl.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800 "gradient test 2"]
    [:div.inline-flex.p-2.font-semibold.bg-gradient-to-b.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800.hover:bg-none.hover:bg-green-400 "gradient test with flat hover color"]
    [:div.inline-flex.w-32.p-2.font-semibold.bg-gradient-to-b.from-indigo-500.to-indigo-900.text-indigo-400.rounded.shadow.shadow-indigo-800.hover:from-pink-500.hover:to-yellow-500 "gradient test with gradient hover color"]]])


(defn app [state]
  [:div.m-6.flex.flex-col
   [:div.text-2xl.mb-6 "Sail Sandbox Environment"]
   [text-sizes]
   [:input.accent-pink-500 {:type :checkbox :default-checked true}]
   [flex-row]
   [flex-col]
   [buttons]
   [media-query-test]
   ])

(rdom/render [app state] (gdom/getElement "app"))
