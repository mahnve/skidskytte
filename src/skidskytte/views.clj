(ns skidskytte.views
  (:require [hiccup.core :as h]
            [hiccup.page :as hp]))

(defn main [name]
  (hp/html5
    [:head
     (hp/include-css "http://yui.yahooapis.com/pure/0.4.2/pure-min.css")
     (hp/include-css "/css/custom.css")]
    [:body
     [:div.container
       [:h1 "Trött på skidskytte?"]
     [:p "Pröva en annan sätt-ihop-två-sporter-till-en-sport:"]
     [:p.sport name]
     [:p.something-else "Det låter trist, jag vill pröva "
      [:a {:href "/"} "något annat"]]]]))

