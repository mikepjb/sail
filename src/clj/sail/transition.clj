(ns sail.transition)

(def transition
  [
   ;; base transition classes
   :transition-none {:transition-property :none}
   :transition-all {:transition-property "all"
                    :transition-timing-function "cubic-bezier(0.4, 0, 0.2, 1)"
                    :transition-duration "150ms"}

   :transition {:transition-property "color, background-color, border-color, text-decoration-color, fill, stroke, opacity, box-shadow, transform, filter, backdrop-filter"
                :transition-timing-function "cubic-bezier(0.4, 0, 0.2, 1)"
                :transition-duration "150ms"}
   :transition-colors {:transition-property "color, background-color, border-color, text-decoration-color, fill, stroke"
                       :transition-timing-function "cubic-bezier(0.4, 0, 0.2, 1)"
                       :transition-duration "150ms"}
   :transition-opacity {:transition-property "opacity"
                        :transition-timing-function "cubic-bezier(0.4, 0, 0.2, 1)"
                        :transition-duration "150ms"}
   :transition-shadow {:transition-property "box-shadow"
                       :transition-timing-function "cubic-bezier(0.4, 0, 0.2, 1)"
                       :transition-duration "150ms"}
   :transition-transform {:transition-property "transform"
                          :transition-timing-function "cubic-bezier(0.4, 0, 0.2, 1)"
                          :transition-duration "150ms"}
   
   ;; duration classes
   :duration-75 {:transition-duration "75ms"}
   :duration-100 {:transition-duration "100ms"}
   :duration-150 {:transition-duration "150ms"}
   :duration-200 {:transition-duration "200ms"}
   :duration-300 {:transition-duration "300ms"}
   :duration-500 {:transition-duration "500ms"}
   :duration-700 {:transition-duration "700ms"}
   :duration-1000 {:transition-duration "1000ms"}

   ;; timing functions
   :ease-linear {:transition-timing-function "linear"}
   :ease-in {:transition-timing-function "cubic-bezier(0.4, 0, 1, 1)"}
   :ease-out {:transition-timing-function "cubic-bezier(0, 0, 0.2, 1)"}
   :ease-in-out {:transition-timing-function "cubic-bezier(0.4, 0, 0.2, 1)"}

   ;; delay
   :delay-75 {:transition-delay "75ms"}
   :delay-100 {:transition-delay "100ms"}
   :delay-150 {:transition-delay "150ms"}
   :delay-200 {:transition-delay "200ms"}
   :delay-300 {:transition-delay "300ms"}
   :delay-500 {:transition-delay "500ms"}
   :delay-700 {:transition-delay "700ms"}
   :delay-1000 {:transition-delay "1000ms"}

   ;;animations
   :animate-none {:animation "none"}
   ])
