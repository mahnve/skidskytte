(ns skidskytte.views
  (:require [hiccup.core :as h]))

(defn main [name]
  (h/html
    [:head]
    [:body
     [:h1 "Trött på skidskytte?"]
     [:p "Pröva en annan sätt-ihop-två-sporter-till-en-sport:"]
     [:p.sport name]]))

