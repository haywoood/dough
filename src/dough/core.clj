(ns dough.core)

(defn ddt
  "calculation desired dough temperature"
  [friction-factor & temps]
  (+ (float (/ (apply + temps) (count temps)))
     friction-factor))

(defn hydration?
  [{:keys [flour water levain] :as recipe
    :or   {levain 0.0}}]
  (let [{:keys [levain-hydration
                alt-flour-pct]
         :or   {levain-hydration 1.0
                alt-flour-pct     0.0}} (meta recipe)]
    (let [levain-water (* levain (/ levain-hydration 2))
          levain-flour (* levain (- 1 (/ levain-hydration 2)))]
      (float (/ (+ water levain-water)
                (+ (* flour (+ 1 alt-flour-pct))
                   levain-flour))))))

(defn scale [recipe amount]
  (reduce-kv (fn [acc k v]
               (assoc acc k (float (* v amount)))) {} recipe))

(defn with-levain
  [{:keys [flour water] :as recipe} levain]
  (let [{:keys [alt-flour-pct] :or {alt-flour-pct 0.0}} (meta recipe)
        total-flour             (* flour (+ 1 alt-flour-pct))
        {:keys [levain-pct hydration]
         :or   {hydration 1.0}} (if (map? levain) levain
                                    {:levain-pct levain
                                     :hydration   1.0})
        flour-in-levain (* total-flour levain-pct)
        water-in-levain (* flour-in-levain hydration)]
    (-> (merge recipe
               {:levain (+ flour-in-levain water-in-levain)
                :flour   (- flour flour-in-levain)
                :water   (- water water-in-levain)})
        (vary-meta assoc :levain-hydration hydration))))

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
    (-> (update new-recipe :flour #(* % (- 1 total-alt-pct)))
        (vary-meta assoc :alt-flour-pct total-alt-pct))))

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
