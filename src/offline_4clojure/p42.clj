; Factorial Fun - Easy
; Write a function which calculates factorials.
; tags - math
; restricted - 
(ns offline-4clojure.p42
  (:use clojure.test))

(def __
  (fn [x]
    (reduce (fn [a b] (* a b)) 1 (range 1 (+ x 1))))
)

(defn -main []
  (are [x] x
(= (__ 1) 1)
(= (__ 3) 6)
(= (__ 5) 120)
(= (__ 8) 40320)
))
