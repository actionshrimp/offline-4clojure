; Prime Numbers - Medium
; Write a function which returns the first x
;number of prime numbers.
; tags - primes
; restricted - 
(ns offline-4clojure.p67
  (:use clojure.test))

(def __
  (fn primes [n]
    (take n 
          (filter 
            (fn [i] (not-any? #(= 0 (mod i %)) (range 2 i))) 
            (drop 2 (range)))))
)

(defn -main []
  (are [x] x
(= (__ 2) [2 3])
(= (__ 5) [2 3 5 7 11])
(= (last (__ 100)) 541)
))

(-main)
