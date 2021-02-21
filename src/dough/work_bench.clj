(ns dough.work-bench
  (:require [dough.core :refer :all]))

;; this was good, forgot the oil, needed more salt
;; https://photos.google.com/photo/AF1QipOvE0biMGOCqUXbrwHfTNBPS_PIuk19Vg3c2eTP
;; baked at 600/600/even heat for 4 minutes
;; need more color on the bottom
(-> {:flour 1.0
     :water 0.7
     :salt 0.025
     :sugar 0.01
     :honey 0.01}
    (gen-recipe 240)
    (with-starter 0.02)
    (scale 3))

;; FORKISH BLONDE COUNTRY

(-> {:flour 1.0
     :water 0.78
     :salt 0.022}
    (gen-recipe 901)
    (scale 2)
    (vary-flour {:whole-wheat 0.05 :rye 0.05})
    (with-starter {:starter-pct 0.08}
                  {:alt-flour-pct 0.1}))

;; FORKISH PIZZA
;; 20-02-2021
(-> {:flour 1.0
     :water 0.7
     :salt 0.02}
    (gen-recipe 250)
    (scale 3)
    (vary-flour {:whole-wheat 0.02})
    (with-starter {:starter-pct 0.07
                   :alt-flour-pct 0.02}))

;; Noel intermediate class
;; 20% levain === 0.002% idy
;; 68 bowl degree
;; 10:50 start mixing
;; 11:13 bulk
;; 11:48
(-> {:flour 1.0
     :water 0.65
     :salt 0.02
     :oil 0.03
     :sugar 0.03
     :idy 0.002}
    (gen-recipe 250)
    (scale 3))

(ddt 5 71 73 60)

;; lombardi guy
;; https://www.pizzamaking.com/forum/index.php?topic=31477.msg312872#msg312872
(-> (percentages?
     {:flour 22679.6
      :water 13248.94
      :sugar 453.59
      :salt  453.59
      :oil   218.0})
    (gen-recipe 235)
    (with-starter 0.02)
    (scale 3))

(def mike-essen
  "https://www.pizzamaking.com/forum/index.php?topic=8093.msg558793#msg558793"
  {:flour 1.0
   :water 0.65
   :salt 0.025
   :oil 0.02
   :honey 0.01
   :sugar 0.01})
