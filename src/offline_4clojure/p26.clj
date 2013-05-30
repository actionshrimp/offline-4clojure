; Fibonacci Sequence - Easy
; Write a function which returns the first X fibonacci numbers.
; tags - Fibonacci:seqs
; restricted - 
(ns offline-4clojure.p26
  (:use clojure.test))

(def __
  (letfn [(fib [x] (cond (= x 1) 1
                         (= x 2) 1
                         :else (+ (fib (- x 1)) (fib (- x 2)))))]
    #(map fib (range 1 (+ % 1))))
)

(defn -main []
  (are [x] x
(= (__ 3) '(1 1 2))
(= (__ 6) '(1 1 2 3 5 8))
(= (__ 8) '(1 1 2 3 5 8 13 21))
))
