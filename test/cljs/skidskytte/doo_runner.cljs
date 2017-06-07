(ns skidskytte.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [skidskytte.core-test]))

(doo-tests 'skidskytte.core-test)

