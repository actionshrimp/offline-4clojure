; Happy numbers - Medium
; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and then sum the squares to get a new number. Repeat with the new number and eventually, you might get to a number whose squared sum is 1. This is a happy number. An unhappy number (or sad number) is one that loops endlessly. Write a function that determines if a number is happy or not.
; tags - math
; restricted - 
(ns offline-4clojure.p86
  (:use clojure.test))

(def __
  (fn [n]
    (letfn [(iter [hist i]
              (cond
                (= 1 i) true
                (some #{i} hist) false
                :else (let [new-hist (conj hist i)
                            j (->> (str i) 
                                   (map str) 
                                   (map #(Integer/valueOf %))
                                   (map #(* % %))
                                   (apply +))]
                        (iter new-hist j))))]
      (iter [] n)))
)

(defn -main []
  (are [x] x
(= (__ 7) true)
(= (__ 986543210) true)
(= (__ 2) false)
(= (__ 3) false)
))
