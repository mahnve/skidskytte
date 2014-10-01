(defproject skidskytte "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :source-paths ["src/clj" "src/cljs"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [org.clojure/clojurescript "0.0-2356"]
                 [reagent "0.4.2"]]
  :uberjar-name "skidskytte-standalone.jar"
  :plugins [[cider/cider-nrepl "0.7.0"]
            [lein-ring "0.8.10"]
            [lein-cljsbuild "1.0.3"]]
  :cljsbuild {:builds
              [{:source-paths ["src/cljs"]
                :compiler {:output-dir "resources/public/js"
                           :output-to "resources/public/js/skidskytte.js"
                           :preamble ["reagent/react.js"]
                           :source-map "resources/public/js/skidskytte.js.map"
                           :optimizations :whitespace
                           :pretty-print true}}]}
  :ring {:handler skidskytte.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]
         :plugins [[com.cemerick/austin "0.1.5"]]}}
  :min-lein-version "2.0.0")
