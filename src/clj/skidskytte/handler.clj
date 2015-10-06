(ns skidskytte.handler
  (:use compojure.core)
  (:gen-class)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [skidskytte.namer :as namer]
            [skidskytte.views :as views]
            [ring.adapter.jetty :as jetty]))

(defroutes app-routes
  (GET "/" [] (views/main (namer/new-sport)))
  (GET "/api/random" [] (namer/new-sport))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& args]
  (jetty/run-jetty app {:port (Integer. (first args)) :join? false}))
