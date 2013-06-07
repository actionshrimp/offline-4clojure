; Sequence Reductions - Medium
; Write a function which behaves like reduce, but returns each intermediate value of the reduction.  Your function must accept either two or three arguments, and the return sequence must be lazy.
; tags - seqs:core-functions
; restricted - reductions
(ns offline-4clojure.p60
  (:use clojure.test))

(def __
  (fn [f & args]
    (let [start (if (= 2 (count args)) (first args) (first (first args)))
          targets (if (= 2 (count args)) (second args) (rest (first args)))]
      (letfn [(get-next [current targets]
        (if (empty? targets) () (cons current (lazy-seq (get-next (f current (first targets)) (rest targets))))))])
      (get-next start targets)))
)

(defn -main []
  (are [x] x
(= (take 5 (__ + (range))) [0 1 3 6 10])
(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
))
