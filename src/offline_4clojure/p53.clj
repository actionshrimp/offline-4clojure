; Longest Increasing Sub-Seq - Hard
; Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify.
; tags - seqs
; restricted - 
(ns offline-4clojure.p53
  (:use clojure.test))

(def __
  (fn [col]
    (let [partitioned (reduce 
                        (fn [acc v] 
                          (if (or (empty? acc) (not (= v (+ 1 (last (last acc))))))
                            (concat acc (list (list v)))
                            (concat (butlast acc) (list (concat (last acc) (list v))))))
                        ()
                        col)]
      (let [sorted (reverse (sort-by count partitioned))]
        (if (> (count (first sorted)) (count (second sorted)))
          (first sorted)
          ()))))
)

(defn -main []
  (are [x] x
(= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
(= (__ [5 6 1 3 2 7]) [5 6])
(= (__ [2 3 3 4 5]) [3 4 5])
(= (__ [7 6 5 4]) [])
))
