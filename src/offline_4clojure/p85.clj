; Power Set - Medium
; Write a function which generates the <a href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself.
; tags - set-theory
; restricted - 
(ns offline-4clojure.p85
  (:use clojure.test))

(def __
  (fn [s]
    (letfn [(g [y]
              (map (partial conj y) s))
            (f [x] 
              (set (mapcat g x)))
            (not-found [x]
              (not (some final-length x)))
            (final-length [x]
              (= (count x) (count s)))]
      (conj (first (drop-while not-found (iterate f #{#{}}))) #{})))
)

(defn -main []
  (are [x] x
(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
(= (__ #{}) #{#{}})
(= (__ #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
(= (count (__ (into #{} (range 10)))) 1024)
))

(-main)
