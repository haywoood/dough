(ns dough.work-bench
  (:require [dough.core :refer :all]))

;; lombardi guy
;; https://www.pizzamaking.com/forum/index.php?topic=31477.msg312872#msg312872
(-> {:flour 1.0
     :water 0.58
     :sugar 0.02
     :salt 0.02
     :oil 0.001}
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
;; great
(-> {:flour 1.0
     :water 0.78
     :salt 0.022}
    (gen-recipe 901)
    (scale 2)
    (vary-flour {:whole-wheat 0.05 :rye 0.05})
    (with-levain 0.08))

;; 2-24-2021
;; 9:00 auto start
;; actual FF 7
(ddt 7 70 71.7 86)
(-> {:flour 1.0
     :water 0.78
     :salt 0.022}
    (gen-recipe 901)
    (scale 2)
    (vary-flour {:whole-wheat 0.05 :rye 0.05})
    (with-levain 0.12))

;; FORKISH PIZZA
;; 20-02-2021
(-> {:flour 1.0
     :water 0.7
     :salt 0.02}
    (gen-recipe 250)
    (scale 3)
    (vary-flour {:whole-wheat 0.02})
    (with-levain 0.07))
;; review: mostly trash
;; dry? didn't brown nicely, kind of doughy

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
     :sugar 0.03
     :idy 0.002}
    (gen-recipe 262)
    (scale 2))

(ddt 5 71 72.5 73 75)

;; 2/22/2021 -- Slow Rise modded for sourdough and 20% blend of other flours
;;
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
;;
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

;; Mix flour water oil sugar and starter and let rest for 15 minutes
;; add salt and mix thoroughly, rest for 5 minutes
;; knead for 5 minutes
;; rest for 5
;; knead for 5 minutes
;; rest for 5
;; in oil and bucket, let rest for 10 minutes
;; first fold
;; rest 10 minutes
;; second fold
;; rest 10 minutes
;; third fold
;; rest 10 minutes
;; fourth fold
;; bulk fermentation continues for 12 (varys based on starter%) hours
;; divide and preshape
;; rest 15 minutes
;; final shapingke

;; 2/24/2021 -- Take 2
;;
;; 7:20 Mixed flour water oil sugar and brought to gether for first rest
;; DT 72.1
;; 7:35 added salt and mixed for 5 minutes
;; 7:40 rest 5 minutes
;; DT 72.1
;; 7:45 knead on block for 5 minutes
;; DT 73
;; 7:50 rest 10 minutes
;; 8:00 Knead on block for 8 minutes
;; DT 76
;; 8:10 Rest minutes
;; 8:20 Knead for 7 minutes
;; DT 77.9
;; 8:28 In bucket with some oil in proofer set to 75f
;; 8:38 first folds
;; DT 76.1
;; 8:50 second fold
;; DT 78.8
;; 9:04 third fold
;; DT 79.7
;; 9:16pm fourth fold
;; 11:20am Divde and shape
;; DT 71.6
(ddt 5 74.3 73.2 67)
(-> {:flour 1.0
     :water 0.65
     :salt 0.02
     :oil 0.03
     :sugar 0.03}
    (gen-recipe 265)
    (with-levain 0.0125)
    (scale 2))

;; 8:27 auto start
;; 8:57 add salt and mix
;; DT 77.1
;; 9:07 knead for 5
(ddt 5 74.3 71.9 73)
(-> {:flour 1.0
     :water 0.65
     :salt 0.02
     :oil 0.03
     :sugar 0.03}
    (gen-recipe 265)
    (with-levain 0.0125)
    (scale 2))

100lbs of flour
26liters of water
(-> {:flour 45359
     :water 26000}
    percentages?)


(-> {:flour 1.0
     :water 0.58
     :salt 0.024}
    (gen-recipe 265)
    (with-levain 0.005)
    (scale 3))

(ddt 7 72.5 70.7 75)

(-> {:flour 1.0
     :water 0.65
     :salt 0.024
     :oil 0.03
     :idy 0.002}
    (gen-recipe 310)
    (scale 4))

(ddt 6 68 72 55)
