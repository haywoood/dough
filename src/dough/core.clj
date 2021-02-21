(ns dough.core)

(defn ddt
  "calculation desired dough temperature"
  [friction-factor & temps]
  (+ (float (/ (apply + temps) (count temps)))
     friction-factor))

(defn scale [recipe amount]
  (reduce-kv (fn [acc k v]
               (assoc acc k (float (* v amount)))) {} recipe))

(defn hydration?
  ([recipe] (hydration? recipe {}))
  ([{:keys [flour water starter]
     :or {starter 0}}
    {:keys [alt-flour-pct starter-hydration]
     :or {alt-flour-pct 0 starter-hydration 1.0}}]
   (let [starter-base (/ starter 2) ;; if it were 100% I'm so bad at math
         flour-in-starter (* starter-base (+ 1 (- 1 starter-hydration)))
         water-in-starter (* starter-base starter-hydration)]
     (float (/ (+ water-in-starter water)
               (+ flour-in-starter (* flour (+ 1 alt-flour-pct))))))))

(defn with-starter
  ([recipe starter] (with-starter recipe starter {}))
  ([{:keys [flour water] :as recipe} starter {:keys [alt-flour-pct]
                                              :or   {alt-flour-pct 0.0}}]
   (let [total-flour             (* flour (+ 1 alt-flour-pct))
         {:keys [starter-pct hydration]
          :or   {hydration 1.0}} (if (map? starter) starter
                                     {:starter-pct starter
                                      :hydration   1.0})
         amt                     (- 1 starter-pct)
         flour-in-starter        (* total-flour starter-pct)
         water-in-starter        (* flour-in-starter hydration)]
     (merge recipe
            {:starter (+ flour-in-starter water-in-starter)
             :flour   (- flour flour-in-starter)
             :water   (- water water-in-starter)}))))

(defn percentages? [{:keys [flour] :as recipe}]
  (letfn [(p [n] (float (/ (or n 0) flour)))]
    (reduce-kv (fn [acc k v]
                 (let [amt (p v)]
                   (if-not (zero? amt)
                     (assoc acc k amt)
                     acc)))
               {}
               recipe)))

(defn vary-flour
  [recipe alt-flours]
  (let [total-alt-pct (apply + (vals alt-flours))
        new-recipe    (reduce-kv (fn [{:keys [flour] :as recipe} flour-name pct-of-flour]
                                   (assoc recipe flour-name (* flour pct-of-flour)))
                                 recipe
                                 alt-flours)]
    (update new-recipe :flour #(* % (- 1 total-alt-pct)))))

(defn gen-recipe [recipe ball-weight]
  (let [rest-amt (apply + (vals (dissoc recipe :flour)))
        flour-amt (/ ball-weight (+ rest-amt 1))]
    (letfn [(p [n] (* flour-amt (or n 0)))]
      (reduce-kv (fn [acc k v]
                   (let [amt (p v)]
                     (if (= :flour k)
                       (assoc acc k flour-amt)
                       (if-not (zero? amt)
                         (assoc acc k amt)
                         acc))))
                 {}
                 recipe))))
