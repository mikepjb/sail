(ns wind.core)

(def sample-output
  ".m-2{margin: 0.25rem;}")

(defn generate-styles []
  (spit "generated-style.css" sample-output))

;; (generate-styles)
