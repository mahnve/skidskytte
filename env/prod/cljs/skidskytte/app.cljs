(ns skidskytte.app
  (:require [skidskytte.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
