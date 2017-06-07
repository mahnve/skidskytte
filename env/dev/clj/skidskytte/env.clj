(ns skidskytte.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [skidskytte.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[skidskytte started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[skidskytte has shut down successfully]=-"))
   :middleware wrap-dev})
