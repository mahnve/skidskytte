(ns skidskytte.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [skidskytte.routes.home :refer [home-routes]]
            [skidskytte.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [skidskytte.env :refer [defaults]]
            [mount.core :as mount]
            [skidskytte.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
   (-> #'home-routes
       (wrap-routes middleware/wrap-formats))
   #'service-routes
   (route/not-found
    "nope")))


(defn app [] (middleware/wrap-base #'app-routes))
