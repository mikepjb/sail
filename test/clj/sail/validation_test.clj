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

(def allowed-properties
  ["-webkit-text-size-adjust"
   "-webkit-box-pack" ;; webkit ext. for box-pack
   "-webkit-box-flex" ;; webkit ext. for box-flex
   "-webkit-box-align" ;; webkit ext. for box-align
   "-webkit-box-ordinal-group" ;; webkit ext. for box-align
   "-webkit-box-orient" ;; webkit ext. for box-align
   "-webkit-box-direction" ;; webkit ext. for box-align
   ;; "::-moz-focus-inner" ;; this isn't a property..
   ])

(defn validate [css-text]
  (let [filename "file://localhost/unused-parameter.css"
        ac (new ApplContext "en")
        usermedium "all"
        ssp (new StyleSheetParser ac)
        input-stream (string->stream css-text)
        _ (.parseStyleElement ssp ac input-stream nil usermedium (new URL filename) 0)
        stylesheet (.getStyleSheet ssp)
        _ (.findConflicts stylesheet ac)
        initial-error-count (.getErrorCount (.getErrors stylesheet))
        errors (map (fn [n]
                    (let [exception-class (.getSimpleName (.getClass (.getException (.getErrorAt (.getErrors stylesheet) n))))]
                      (if (= exception-class "CssParseException")
                        (when-not (some #{(.getProperty (.getException (.getErrorAt (.getErrors stylesheet) n)))} allowed-properties)
                          (.getMessage (.getException (.getErrorAt (.getErrors stylesheet) n))))
                        (.getMessage (.getException (.getErrorAt (.getErrors stylesheet) n)))
                      )))
                    (take 100 (range 0 initial-error-count)))
        error-count (count errors)]

    {:error-count error-count
     :errors errors}))

(deftest generated-css-correctness
  (testing "the unpurged css we generate is valid according to the w3c css validator"
    (let [css-text (core/internal-generate-styles core/all components/components)
          results (validate css-text)]
      
      (is (= (:error-count results) 0)))))

;; (comment
  (def css-text (core/internal-generate-styles core/all components/components))
  (doseq [n (:errors (validate css-text))]
    (prn n))
  ;; )
