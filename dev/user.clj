(ns user
  (:require [figwheel.main.api :as figwheel]
            [juxt.dirwatch :as dw]
            [clojure.java.shell :refer [sh]]
            [sail.core :as sail]))

(defn start-figwheel! []
  (figwheel/start
    {:id "dev"
     :options {:output-to "target/public/cljs-out/main.js"
               :main 'sail.sandbox}
     :config {:watch-dirs ["src/cljs" "src/cljc"]
              :open-url false
              :mode :serve
              :connect-url "http://172.27.74.87:9500/figwheel-connect" ;; for WSL2 only
              }}))

(def css-watcher (atom nil))

(defn start-css-watch! []
  (reset! css-watcher (sail/watch "target/public/styles.gen.css")))

(defn close-watcher [] (dw/close-watcher @css-watcher))
(defn restart-watcher []
  (dw/close-watcher @css-watcher)
  (start-css-watch!))

(defn dev []
  (sh "mkdir" "-p" "./target/public")
  ;; (sail/generate-styles "target/public/styles.gen.css")
  (start-css-watch!)
  (start-figwheel!))
