(ns user
  (:require [figwheel.main.api :as figwheel]
            ;; [juxt.dirwatch :as dw]
            [clojure.java.shell :refer [sh]]
            [sail.core :as sail]))

(defn start-figwheel! []
  (figwheel/start
    {:id "dev"
     :options {:output-to "target/public/cljs-out/main.js"
               :main 'sail.sandbox}
     :config {:watch-dirs ["src/cljs" "src/cljc"]
              :css-dirs ["target/public/styles.gen.css"]
              :open-url false
              :mode :serve
              ;; TODO watch out for this!
              ;; :connect-url "http://172.27.74.87:9500/figwheel-connect" ;; for WSL2 only
              }}))

(defn start-css-watch! []
  ;; N.B global version, works for projects other than sail where, because we define all the classes, everything will
  ;; be generated!
  ;; (sail/watch "target/public/styles.gen.css")
  (sail/watch "target/public/styles.gen.css" {:paths ["./src/cljs" "./resources"]})
  ;; (sail/watch "target/public/styles.gen.css" {:paths ["./src/cljs"]})
  )

(defn stop-css-watch! []
  (sail/stop-watch))

(defn build-css! []
  (sail/build "styles.test.gen.css" {:paths ["./src/cljs"]}))

(defn dev []
  (start-css-watch!)
  (start-figwheel!))
