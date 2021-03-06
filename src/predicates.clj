(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x) ))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (empty? (filter (fn [x] (not (has-award? book x)))  awards)))

(defn my-some [pred a-seq]
  (first (filter (fn [x] (if x true)) (map (fn [x] (pred x)) a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (fn [x] (if (not x) true)) (map (fn [x] (pred x)) a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (integer? (/ n x)))]
    (not (some pred (range 2 n)))))
;^^
