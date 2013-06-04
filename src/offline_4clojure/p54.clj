; Partition a Sequence - Medium
; Write a function which returns a sequence of lists of x items each.  Lists of less than x items should not be returned.
; tags - seqs:core-functions
; restricted - partition:partition-all
(ns offline-4clojure.p54
  (:use clojure.test))

(def __
  (fn [cnt col]
    (let [partitioned (reduce 
                        (fn [acc v] (if (< (count (last acc)) cnt)
                                      (concat (butlast acc) (list (concat (last acc) (list v))))
                                      (concat acc (list (list v))))) 
                        '(()) col)]
      (filter #(= cnt (count %)) partitioned)))
)

(defn -main []
  (are [x] x
(= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
(= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
(= (__ 3 (range 8)) '((0 1 2) (3 4 5)))
))
