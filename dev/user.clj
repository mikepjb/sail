(ns user
  (:require [figwheel.main.api :as figwheel]
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

(defn dev []
  (sh "mkdir" "-p" "./target/public")
  (sail/generate-styles "target/public/styles.gen.css")
  (start-figwheel!))
