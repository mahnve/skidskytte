(ns skidskytte.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [skidskytte.namer :as namer]
            [skidskytte.views :as views]))

(defroutes app-routes
  (GET "/" [] (views/main (namer/new-sport)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
