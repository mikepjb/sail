(ns sail.sandbox
  (:require [goog.dom :as gdom]
            [reagent.core :as r]
            [reagent.dom :as rdom]))

(defonce state (r/atom {}))

(println "Sail Sandbox Environment")

(defn app [state]
  [:div.m-4.flex.flex-col
   "Sail Sandbox Environment"
   [:div.w-32.my-4.p-2.font-semibold.bg-orange-300.text-orange-900.rounded.shadow.shadow-orange-800 "hello"]
   ])

(rdom/render [app state] (gdom/getElement "app"))
