(ns skidskytte.routes.services
  (:require [ring.util.http-response :as response]
            [compojure.api.sweet :as swagger]
            [schema.core :as s]
            [skidskytte.namer :as namer]))

(swagger/defapi service-routes
  {:swagger {:ui "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version "1.0.0"
                           :title "Skidskytteroulette API"
                           :description "For all your sportsing needs"}}}}

  (swagger/context "/api"
                   []
                   (swagger/GET "/new-sport" []
                                :return       {:sport s/Str}
                                :query-params []
                                :summary      "Returns a new fun sport!"
                                (response/ok {:sport (namer/new-sport)}))))
