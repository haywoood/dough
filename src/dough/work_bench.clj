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
    (with-levain 0.02)
    (scale 3))

;; FORKISH BLONDE COUNTRY

(-> {:flour 1.0
     :water 0.78
     :salt 0.022}
    (gen-recipe 901)
    (scale 2)
    (vary-flour {:whole-wheat 0.05 :rye 0.05})
    (with-levain 0.08))

;; FORKISH PIZZA
;; 20-02-2021
(-> {:flour 1.0
     :water 0.7
     :salt 0.02}
    (gen-recipe 250)
    (scale 3)
    (vary-flour {:whole-wheat 0.02})
    (with-levain 0.07))

;; Noel intermediate class
;; levain% = idy% * 100
;; 68 bowl degree
;; 10:50 start mixing
;; 11:13 bulk
;; 11:48
(-> {:flour 1.0
     :water 0.65
     :salt 0.02
     :oil 0.03
     :sugar 0.03}
    (gen-recipe 262)
    (vary-flour {:whole-wheat 0.12 :rye 0.08})
    (with-levain 0.025)
    (scale 2))

(ddt 5 71 72.5 73 75)

;; 2/22/2021
;; Mixed flour water oil sugar and brought to gether for first rest at 8:55
;; 9:08pm added salt and mixed for 4 minutes rest 5 minutes
;; 9:16 knead on block for 5 minutes
;; 9:21 rest 5 minutes DT 80.3 put in fridge uncovered
;; 9:26 Knead on block for 5 minutes
;; 9:32 In bucket with some oil DT 79 popped in fridge for 7 minutes
;; 9:42 first folds DT 76.8
;; 10:03 second folds DT 75.3
;; 10:21 third fold DT 75.1
;; 11:15pm Last fold DT 74.8
;; 11:40am divide and preshape and rest DT 72.5
;; 11:52 After bench rest final shaping and putting into bowls
;; ----
;; FF 5 from last time
(ddt 5 71 72.5 73 75)
;; Actual friction factor 8
(ddt 8 71 72.5 73 75)
(-> {:flour 1.0
     :water 0.65
     :salt 0.02
     :oil 0.03
     :sugar 0.03}
    (gen-recipe 262)
    (vary-flour {:whole-wheat 0.12 :rye 0.08})
    (with-levain 0.025)
    (scale 2))

;; lombardi guy
;; https://www.pizzamaking.com/forum/index.php?topic=31477.msg312872#msg312872
(-> (percentages?
     {:flour 22679.6
      :water 13248.94
      :sugar 453.59
      :salt  453.59
      :oil   218.0})
    (gen-recipe 235)
    (with-levain 0.02)
    (scale 3))

(def mike-essen
  "https://www.pizzamaking.com/forum/index.php?topic=8093.msg558793#msg558793"
  {:flour 1.0
   :water 0.65
   :salt 0.025
   :oil 0.02
   :honey 0.01
   :sugar 0.01})
