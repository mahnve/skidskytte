(set-env! :source-paths #{"src/clj" "src/cljs" "test"}
          :resource-paths #{"resources"}
          :dependencies '[[org.clojure/clojure "1.8.0"]
                          [compojure "1.1.6"]
                          [hiccup "1.0.5"]
                          [ring/ring-jetty-adapter "1.1.6"]
                          [org.clojure/clojurescript "1.7.122"]
                          [reagent "0.4.2"]
                          [boot-deps "0.1.6"]
                          [cljs-ajax "0.3.2"]
                          [ring-mock "0.1.5" :scope "test"]
                          [adzerk/boot-test "1.2.0" :scope "test"]
                          [tolitius/boot-check "0.1.4" :scope "test"]])

(require '[adzerk.boot-test :refer :all]
         '[boot-deps :refer [ancient]])

(task-options! pom {:project 'skidskytte
                    :version "0.1.0"}
               aot {:namespace '#{skidskytte.handler}}
               jar {:main 'skidskytte.handler
                    :file "skidskytte-app.jar"})

(deftask uberjar []
  "Builds uberjar"
  (comp
   (aot)
   (pom)
   (uber)
   (jar)
   (target)))
