; Sequence Reductions - Medium
; Write a function which behaves like reduce, but returns each intermediate value of the reduction.  Your function must accept either two or three arguments, and the return sequence must be lazy.
; tags - seqs:core-functions
; restricted - reductions
(ns offline-4clojure.p60
  (:use clojure.test))

(def __
  (fn r
    ([f xs] (r f (first xs) (rest xs)))
    ([f acc xs]
     (lazy-seq
       (cons acc
             (if (empty? xs) [] (r f (f acc (first xs)) (rest xs)))))))
)

(defn -main []
  (are [x] x
(= (take 5 (__ + (range))) [0 1 3 6 10])
(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
))
