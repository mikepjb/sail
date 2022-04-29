(ns sail.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [sail.core :as sail]
            [clojure.string]
            [sail.components :as components]
            [sail.color :refer [color-class]]))

(def test-styles
  [:main {:display "block"}
   :h1 {:font-size "2em", :margin "0.67em 0"}
   :hr {:box-sizing "content-box", :height 0, :overflow "visible"}])

(def psuedo-class-test-styles
  (take 4 (components/with-pseudo-class "hover"
            (color-class "bg" "background-color"))))

;; N.B clojure expresses \ as \\ in strings.
(deftest responsive-prefix
  (testing "we can apply a media query to a list of css rules"
    (is (= (sail/with-responsive-prefix test-styles "xx" "300px") 
           "@media (min-width: 300px){.xx\\:main{display:block;}.xx\\:h1{font-size:2em;margin:0.67em 0;}.xx\\:hr{box-sizing:content-box;height:0;overflow:visible;}}"))))

(deftest psuedo-classes
  (testing "psuedo classes are encoded correctly"
    (is (= (sail/with-responsive-prefix psuedo-class-test-styles "xx" "300px") 
           "@media (min-width: 300px){.xx\\:hover\\:bg-stone-800:hover{background-color:#292524;}.xx\\:hover\\:bg-red-700:hover{background-color:#c53030;}}"))))


(deftest style->string
  (testing "styles can be changed into css strings"
    (is (= (sail/style->string test-styles) 
           "main{display:block;}h1{font-size:2em;margin:0.67em 0;}hr{box-sizing:content-box;height:0;overflow:visible;}"))))
