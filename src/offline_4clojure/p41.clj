; Drop Every Nth Item - Easy
; Write a function which drops every Nth item from a sequence.
; tags - seqs
; restricted - 
(ns offline-4clojure.p41
  (:use clojure.test))

(def __
#(map second
      (filter 
        (partial apply (fn [i el] (not (= 0 (mod (+ 1 i) %2))))) 
        (map-indexed (fn [a b] (list a b)) %1)))
)

(defn -main []
  (are [x] x
(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
))
