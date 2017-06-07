(ns skidskytte.core
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [ajax.core :as ajax]))

(def state (r/atom {}))

(defn sport []
  [:span (:sport @state)])

(defn fetch-sport! []
  (ajax/GET "/api/new-sport"
            {:handler (fn [{:keys [sport]}]
                        (swap! state assoc :sport sport))}))

(defn link []
  [:a {:href "#"
       :on-click fetch-sport!} "något annat"])

(defn mount-components []
  (r/render [#'sport] (.getElementById js/document "sport"))
  (r/render [#'link] (.getElementById js/document "link")))

(defn init! []
  (fetch-sport!)
  (mount-components))
