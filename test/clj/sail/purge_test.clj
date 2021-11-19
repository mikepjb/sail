(ns sail.purge-test
  (:require [clojure.test :refer [deftest testing is]]
            [sail.core :as sail]
            [clojure.string]
            [sail.components :refer [components]]))

(comment
  (def all-keywords (sail/all-project-keywords))
  (count all-keywords)
  (take 30 all-keywords)

  (take 50 sail/all)

  (partition 2 (take 30 sail/all))

  ;; TODO this sexp shows things that would be 'over-purged'
  ;; e.g [:button :type\[submit\]] list would keep button but purge submit even
  ;; if you're using a button of type submit e.g
  ;; [:button {:type :submit}]
  (map (fn [[k v]] k)
       (partition 2 (take 300 sail/all)))
  )

(deftest splitting-tags
  (testing "We can split :div.md-4 style keywords found in our source code"
    (is (= (sail/split-tags-and-classes [:span.text-red-500.p-4])
           [:span :text-red-500 :p-4])))
  
  (testing "Splitting multiple keywords will result in a single seq"
    (is (= (sail/split-tags-and-classes [:span.text-red-500.p-4 :div.flex.flex-col.items-center.shadow])
           [:span :text-red-500 :p-4 :div :flex :flex-col :items-center :shadow]))))

(deftest purge-mechanic
  (testing "We can purge unused classes"
    (is (= (sail/purge-styles sail/all [:text-red-500 :body :bg-green-300 :bg-red-400])
           [:body {:margin 0}
            :bg-red-400 {:background-color "#fc8181"}
            :bg-green-300 {:background-color "#9ae6b4"}
            :text-red-500 {:color "#f56565"}])))
  
  (testing "We can purge unused classes using :div.md-4 style keywords found in our source code"
    (is (= (sail/purge-styles sail/all [:span.text-red-500 :body.p-4 :div.m-4.bg-green-300 :bg-red-400])
           [:body {:margin 0}
            :bg-red-400 {:background-color "#fc8181"}
            :bg-green-300 {:background-color "#9ae6b4"}
            ;; no div here as there are no pre-defined styles for it
            :m-4 {:margin "1rem"}
            :p-4 {:padding "1rem"}
            :text-red-500 {:color "#f56565"}])))

  (testing "text-pink-800 and it's media query classes (e.g sm:text-pink-800) are not included as it wasn't used in the project"
    (is (not (clojure.string/includes?
                (sail/internal-generate-styles
                  (sail/purge-styles sail/all [:span.text-red-500 :body.p-4 :div.m-4.bg-green-300 :bg-red-400])
                  (sail/purge-styles components [:span.text-red-500 :body.p-4 :div.m-4.bg-green-300 :bg-red-400]))
                "text-pink-800")))))
