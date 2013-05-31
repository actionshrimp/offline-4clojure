; Implement range - Easy
; Write a function which creates a list of all integers in a given range.
; tags - seqs:core-functions
; restricted - range
(ns offline-4clojure.p34
  (:use clojure.test))

(def __
  (fn [start end]
    (letfn [(f [acc x]
              (if (= x end)
                acc
                (f (cons x acc) (+ x 1))))]
      (reverse (f () start))))
)

(defn -main []
  (are [x] x
(= (__ 1 4) '(1 2 3))
(= (__ -2 2) '(-2 -1 0 1))
(= (__ 5 8) '(5 6 7))
))
