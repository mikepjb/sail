(ns sail.validation-test
  (:require [clojure.test :refer [deftest testing is]]
            [sail.core :as core]
            [sail.components :as components])
  (:import (org.w3c.css.css StyleSheetParser)
           (org.w3c.css.util ApplContext)
           (java.net URL)))

(defn string->stream
  ([s] (string->stream s "UTF-8"))
  ([s encoding]
   (-> s
       (.getBytes encoding)
       (java.io.ByteArrayInputStream.))))

(defn validate [css-text]
  (let [filename "file://localhost/unused-parameter.css"
        ac (new ApplContext "en")
        usermedium "all"
        ssp (new StyleSheetParser ac)
        input-stream (string->stream file)
        _ (.parseStyleElement ssp ac input-stream nil usermedium (new URL filename) 0)
        stylesheet (.getStyleSheet ssp)
        _ (.findConflicts stylesheet ac)
        error-count (.getErrorCount (.getErrors stylesheet))]

    {:error-count error-count
     :errors (map (fn [n]
                    (.getMessage (.getException (.getErrorAt (.getErrors stylesheet) n))))
                    (range 0 error-count))}))

(deftest generated-css-correctness
  (testing "the unpurged css we generate is valid according to the w3c css validator"
    (let [css-text (core/internal-generate-styles core/all components/components)
          results (validate css-text)]
      
      (is (= (:error-count results) 0)))))

(comment
  (def css-text (core/internal-generate-styles core/all components/components))
  (doseq [n (take 20 (:errors (validate css-text)))]
    (prn n))
  )
