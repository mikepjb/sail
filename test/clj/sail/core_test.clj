(ns sail.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [sail.core :as sail]
            [clojure.string]
            [sail.components :refer [components]]))

(def test-styles
  [:main {:display "block"}
   :h1 {:font-size "2em", :margin "0.67em 0"}
   :hr {:box-sizing "content-box", :height 0, :overflow "visible"}])

;; N.B clojure expresses \ as \\ in strings.
(deftest responsive-prefix
  (testing "we can apply a media query to a list of css rules"
    (is (= (sail/with-responsive-prefix test-styles "xx" "300px") 
           "@media (min-width: 300px){.xx\\:main{display:block;}.xx\\:h1{font-size:2em;margin:0.67em 0;}.xx\\:hr{box-sizing:content-box;height:0;overflow:visible;}}"))))

(deftest style->string
  (testing "styles can be changed into css strings"
    (is (= (sail/style->string test-styles) 
           "main{display:block;}h1{font-size:2em;margin:0.67em 0;}hr{box-sizing:content-box;height:0;overflow:visible;}"))))
