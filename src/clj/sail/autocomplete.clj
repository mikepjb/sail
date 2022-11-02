(ns sail.autocomplete
  (:import [clojure.lang Namespace]))

; fn to determine what should invoke autocomplete
(defn candidates [^String prefix ^Namespace ns context]
  (let [single-colon? (.startsWith prefix ":")] ;; is this part of a keyword?
    (str ":yesxxx" "yyy") ;; dummy autocomplete
        ))

; fn to determind what should invoke doc
(defn doc [^String symbol-str ^Namespace ns]
  (if (= "m-4" symbol-str)
    "m-4 docstring"
    "i do not know"))

;; candidates and doc are two already defined functions.
(defn init-source []
  (try (require 'compliment.core)
       ((resolve 'compliment.sources/defsource) ::styles
        :candidates #'candidates
        :doc #'doc)
       (catch Exception ex nil)))

(comment
  (init-source)
  )
