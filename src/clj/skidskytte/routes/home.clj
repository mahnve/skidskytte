(ns skidskytte.routes.home
  (:require [clojure.java.io :as io]
            [compojure.core :refer [defroutes GET]]
            [markdown.core :as markdown]
            [ring.util.http-response :as response]
            [skidskytte.namer :as namer]
            [skidskytte.views :as views]))

(defroutes home-routes
  (GET "/" []
       (views/base (namer/new-sport))))

