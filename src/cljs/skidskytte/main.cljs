(ns skidskytte.main
  (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :refer [GET]]))

(def current-sport (atom ""))

(defn sport []
  [:span @current-sport])

(defn handler [response]
  (reset! current-sport (str response)))

(defn get-new-sport []
  (GET "/api/random" {:handler handler}))

(defn render []
  (get-new-sport)
  (reagent/render-component [sport]
                            (.getElementById js/document "sport")))
