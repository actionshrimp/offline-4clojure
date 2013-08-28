; Least Common Multiple - Easy
; Write a function which calculates the <a href="http://en.wikipedia.org/wiki/Least_common_multiple">least common multiple</a>.  Your function should accept a variable number of positive integers or ratios. 
; tags - math
; restricted - 

;LCM of fractions = LCM of numerators / HCF of denominators

(ns offline-4clojure.p100
  (:use clojure.test))

(def __
  (fn [& xs]
    (let [gcd (fn [a b] (if (= b 0) a (recur b (mod a b))))
          lcm (fn [a b] (/ (* a b) (gcd a b)))
          numer #(if (integer? %) % (numerator %))
          denom #(if (integer? %) 1 (denominator %))
          f (fn [x y] (/ 
                        (lcm (numer x) (numer y))
                        (gcd (denom x) (denom y))))]
    (reduce f xs)))
)

(defn -main []
  (are [x] x
(== (__ 2 3) 6)
(== (__ 5 3 7) 105)
(== (__ 1/3 2/5) 2)
(== (__ 3/4 1/6) 3/2)
(== (__ 7 5/7 2 3/5) 210)
))
