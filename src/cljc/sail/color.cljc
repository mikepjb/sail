(ns sail.color
  (:require [clojure.string :as s])
  (:import [java.lang Integer]))

(Integer/parseInt "f0" 16)

(defn hex->rgba [hex opacity]
  (let [hex-values
        (-> hex
            (s/replace #"#" "")
            (s/split #"")
            ((fn [hs] (if (= 3 (count hs)) ;; convert 3 char hex -> 6 char hex
                        (map #(s/join (repeat 2 %)) hs)
                        (map #(s/join %) (partition 2 hs)))))
            ((fn [hs] (map #(Integer/parseInt % 16) hs))))]
    (str "rgb(" (s/join " " (into [] hex-values)) "/" opacity ")")))

;; (hex->rgba "#fff" 50)
;; (hex->rgba "#f0e333" 50)

(def palette
  {:white "#fff"
   :black "#000"
   :slate-50 "#f8fafc"
   :slate-100 "#f1f5f9"
   :slate-200 "#e2e8f0"
   :slate-300 "#cbd5e1"
   :slate-400 "#94a3b8"
   :slate-500 "#64748b"
   :slate-600 "#475569"
   :slate-700 "#334155"
   :slate-800 "#1e293b"
   :slate-900 "#0f172a"
   :gray-100 "#f7fafc"
   :gray-200 "#edf2f7"
   :gray-300 "#e2e8f0"
   :gray-400 "#cbd5e0"
   :gray-500 "#a0aec0"
   :gray-600 "#718096"
   :gray-700 "#4a5568"
   :gray-800 "#2d3748"
   :gray-900 "#1a202c"
   :red-100 "#fff5f5"
   :red-200 "#fed7d7"
   :red-300 "#feb2b2"
   :red-400 "#fc8181"
   :red-500 "#f56565"
   :red-600 "#e53e3e"
   :red-700 "#c53030"
   :red-800 "#9b2c2c"
   :red-900 "#742a2a"
   :orange-100 "#fffaf0"
   :orange-200 "#feebc8"
   :orange-300 "#fbd38d"
   :orange-400 "#f6ad55"
   :orange-500 "#ed8936"
   :orange-600 "#dd6b20"
   :orange-700 "#c05621"
   :orange-800 "#9c4221"
   :orange-900 "#7b341e"
   :yellow-100 "#fffff0"
   :yellow-200 "#fefcbf"
   :yellow-300 "#faf089"
   :yellow-400 "#f6e05e"
   :yellow-500 "#ecc94b"
   :yellow-600 "#d69e2e"
   :yellow-700 "#b7791f"
   :yellow-800 "#975a16"
   :yellow-900 "#744210"
   :lime-50 "#f7fee7"
   :lime-100 "#ecfccb"
   :lime-200 "#d9f99d"
   :lime-300 "#bef264"
   :lime-400 "#a3e635"
   :lime-500 "#84cc16"
   :lime-600 "#65a30d"
   :lime-700 "#4d7c0f"
   :lime-800 "#3f6212"
   :lime-900 "#365314"
   :green-100 "#f0fff4"
   :green-200 "#c6f6d5"
   :green-300 "#9ae6b4"
   :green-400 "#68d391"
   :green-500 "#48bb78"
   :green-600 "#38a169"
   :green-700 "#2f855a"
   :green-800 "#276749"
   :green-900 "#22543d"
   :teal-100 "#e6fffa"
   :teal-200 "#b2f5ea"
   :teal-300 "#81e6d9"
   :teal-400 "#4fd1c5"
   :teal-500 "#38b2ac"
   :teal-600 "#319795"
   :teal-700 "#2c7a7b"
   :teal-800 "#285e61"
   :teal-900 "#234e52"
   :cyan-50  "#ecfeff"
   :cyan-100 "#cffafe"
   :cyan-200 "#a5f3fc"
   :cyan-300 "#67e8f9"
   :cyan-400 "#22d3ee"
   :cyan-500 "#06b6d4"
   :cyan-600 "#0891b2"
   :cyan-700 "#0e7490"
   :cyan-800 "#155e75"
   :cyan-900 "#164e63"
   :blue-100 "#ebf8ff"
   :blue-200 "#bee3f8"
   :blue-300 "#90cdf4"
   :blue-400 "#63b3ed"
   :blue-500 "#4299e1"
   :blue-600 "#3182ce"
   :blue-700 "#2b6cb0"
   :blue-800 "#2c5282"
   :blue-900 "#2a4365"
   :indigo-100 "#ebf4ff"
   :indigo-200 "#c3dafe"
   :indigo-300 "#a3bffa"
   :indigo-400 "#7f9cf5"
   :indigo-500 "#667eea"
   :indigo-600 "#5a67d8"
   :indigo-700 "#4c51bf"
   :indigo-800 "#434190"
   :indigo-900 "#3c366b"
   :purple-100 "#faf5ff"
   :purple-200 "#e9d8fd"
   :purple-300 "#d6bcfa"
   :purple-400 "#b794f4"
   :purple-500 "#9f7aea"
   :purple-600 "#805ad5"
   :purple-700 "#6b46c1"
   :purple-800 "#553c9a"
   :purple-900 "#44337A"
   :pink-100 "#fff5f7"
   :pink-200 "#fed7e2"
   :pink-300 "#fbb6ce"
   :pink-400 "#f687b3"
   :pink-500 "#ed64a6"
   :pink-600 "#d53f8c"
   :pink-700 "#b83280"
   :pink-800 "#97266d"
   :pink-900 "#702459"})

(defn color-class [prefix property]
  "Generates the css classes for a given property, for all colors."
  (reduce (fn [coll [color hex]]
            (into coll [(keyword (str prefix "-" (name color)))
                        {(keyword property) hex}]))
          [] palette))

(defn rgba-color-class [prefix property rgba-property opacity]
  "Generates the css classes for a given property, for all colors."
  (reduce (fn [coll [color hex]]
            (into coll [(keyword (str prefix "-" (name color)))
                        {(keyword property) "var(--tw-shadow-colored)"
                         (keyword rgba-property) (hex->rgba hex opacity)}]))
          [] palette))
