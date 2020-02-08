(ns sail.color)

(def palette
  {:white "#fff"
   :black "#000"
   :gray-100 "#f7fafc"
   :gray-200 "#edf2f7"
   :gray-300 "#e2e8f0"
   :gray-400 "#cbd5e0"
   :gray-500 "#a0aec0"
   :gray-600 "#718096"
   :gray-700 "#4a5568"
   :gray-800 "#2d3748"
   :gray-900 "#1a202c"
   })

(defn color-class [prefix property]
  "Generates the css classes for a given property, for all colors."
  (reduce (fn [coll [color hex]]
            (into coll [(keyword (str prefix "-" (name color)))
                        {(keyword property) hex}]))
          [] palette))
