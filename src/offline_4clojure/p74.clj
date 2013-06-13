; Filter Perfect Squares - Medium
; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.
; tags - 
; restricted - 
(ns offline-4clojure.p74
  (:use clojure.test))

(def __
  (fn [s] 
    (let [isSquare (fn [x]
                     (let [n (Integer/parseInt x)
                           sqrt (Math/sqrt n)
                           floored (int (Math/floor sqrt))]
                       (= n (* floored floored))))]
    (->> s
         (re-seq #"\d+")
         (filter isSquare)
         (clojure.string/join ","))))
  )

(defn -main []
  (are [x] x
       (= (__ "4,5,6,7,8,9") "4,9")
       (= (__ "15,16,25,36,37") "16,25,36")
       ))

(-main)
