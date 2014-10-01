(ns skidskytte
  (:require [reagent.core :as reagent :refer [atom]]))

(defn sport []
  [:span "Sport"])

(defn render []
  (reagent/render-component [sport]
                            (.getElementById js/document "sport")))
