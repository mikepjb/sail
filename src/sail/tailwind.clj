(ns sail.tailwind
  (:require [sail.color :as color]))

(def custom-reset
  (array-map
    :html {;; Use the system font stack as a sane default.
           :font-family "-apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, \"Noto Sans\", sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\", \"Noto Color Emoji\""
           ;; Use Tailwind's default "normal" line-height so the user isn't forced
           ;; to override it to ensure consistency even when using the default theme.
           :line-height 1.5}
    
    ;; Allow adding a border to an element by just adding a border-width.
    [:* (keyword "*::before") (keyword "*::after")] {:border-width 0 :border-style "solid" :border-color color/gray-300}

    ;; Ensure horizontal rules are visible by default
    :hr {:border-top-width "1px"}

    ;; TODO Remove the border-style: none reset from Normalize
    ;; Undo the border-style: none reset for images
    :img {:border-style "solid"}

    :textarea {:resize "vertical"}

    ;; stopped at L487.. looks like the work of autoprefixer, I'd like to
    ;; abstract this work here too to keep things DRY.
    ))

(def tailwind custom-reset)
