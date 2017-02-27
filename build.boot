(set-env! :source-paths #{"src/clj" "src/cljs" "test"}
          :resource-paths #{"resources"}
          :dependencies '[[org.clojure/clojure "1.8.0"]
                          [compojure "1.5.2"]
                          [hiccup "1.0.5"]
                          [ring/ring-jetty-adapter "1.5.1"]
                          [org.clojure/clojurescript "1.9.456"]
                          [reagent "0.6.0"]
                          [boot-deps "0.1.6"]
                          [cljs-ajax "0.5.8"]
                          [ring-mock "0.1.5" :scope "test"]
                          [adzerk/boot-test "1.2.0" :scope "test"]
                          [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                          [adzerk/boot-cljs-repl "0.3.3"]
                          [com.cemerick/piggieback "0.2.1" :scope "test"]
                          [org.clojure/tools.nrepl "0.2.12" :scope "test"]
                          [weasel "0.7.0" :scope "test"]
                          [tolitius/boot-check "0.1.4" :scope "test"]
                          [adzerk/boot-reload "0.5.0"]])

(require '[adzerk.boot-test :refer :all]
         '[adzerk.boot-cljs :refer [cljs]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
         '[adzerk.boot-reload :refer :all]
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
   (cljs)
   (pom)
   (uber)
   (jar)
   (target)))


(deftask dev []
  (comp
   (watch)
   (reload)
   (cljs-repl)
   (cljs)
   (target)))
