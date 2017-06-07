(ns user
  (:require [mount.core :as mount]
            [skidskytte.figwheel :refer [start-fw stop-fw cljs]]
            skidskytte.core))

(defn start []
  (mount/start-without #'skidskytte.core/repl-server))

(defn stop []
  (mount/stop-except #'skidskytte.core/repl-server))

(defn restart []
  (stop)
  (start))


