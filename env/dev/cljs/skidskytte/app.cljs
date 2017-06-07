(ns ^:figwheel-no-load skidskytte.app
  (:require [skidskytte.core :as core]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(core/init!)
