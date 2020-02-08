(ns sail.color)

(def palette
  {:white "#fff"
   :black "#000"
   :gray-100 "#f7fafc"
   :gray-200 "#edf2f7"
   :gray-300 "#e2e8f0"})

(defn color-class [prefix property]
  "Generates the css classes for a given property, for all colors."
  (reduce
    str
    (map
      (fn [[color-key hex]]
        (str "." prefix "-" (name color-key) "{"
             property ":" hex ";}")) palette)))
