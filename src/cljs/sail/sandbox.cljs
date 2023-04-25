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

(defn app [state]
  [:div.m-4.flex.flex-col
   "Sail Sandbox Environment"
   [:div.w-32.my-4.p-2.font-semibold.bg-red-300.text-orange-900.rounded.shadow.shadow-orange-800 "hello"]
   [flex-row]
   [flex-col]
   [media-query-test]
   ])

(rdom/render [app state] (gdom/getElement "app"))
