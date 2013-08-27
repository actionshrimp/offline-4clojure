; Product Digits - Easy
; Write a function which multiplies two numbers and returns the result as a sequence of its digits.
; tags - math:seqs
; restricted - 
(ns offline-4clojure.p99
  (:use clojure.test))

(def __
  #(map (fn [x] (Integer/parseInt x)) (map str (str (* %1 %2))))
  
)

(defn -main []
  (are [x] x
(= (__ 1 1) [1])
(= (__ 99 9) [8 9 1])
(= (__ 999 99) [9 8 9 0 1])
))
