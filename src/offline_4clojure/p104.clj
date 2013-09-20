; Write Roman Numerals - Medium
; This is the inverse of <a href='92'>Problem 92</a>, but much easier. Given an integer smaller than 4000, return the corresponding roman numeral in uppercase, adhering to the <a href='http://www.numericana.com/answer/roman.htm#valid'>subtractive principle</a>.
; tags - strings:math
; restricted - 
(ns offline-4clojure.p104
  (:use clojure.test))

(def __
  (fn [n] 
    (apply str ((fn roman [n]
      (if (> n 0)
        (let [values [[1000 "M"], [900 "CM"], [500 "D"],
                      [400 "CD"], [100 "C"], [90 "XC"],
                      [50 "L"], [40 "XL"], [10 "X"],
                      [9 "IX"], [5 "V"], [4 "IV"], [1 "I"]]
              to-remove (first (filter #(>= n (first %)) values))
              m (first to-remove)
              c (second to-remove)]
          (concat c (roman (- n m))))
        ())) n)))
)

(defn -main []
  (are [x] x
(= "I" (__ 1))
(= "XXX" (__ 30))
(= "IV" (__ 4))
(= "CXL" (__ 140))
(= "DCCCXXVII" (__ 827))
(= "MMMCMXCIX" (__ 3999))
(= "XLVIII" (__ 48))
))
