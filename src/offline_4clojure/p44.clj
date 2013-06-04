; Rotate Sequence - Medium
; Write a function which can rotate a sequence in either direction.
; tags - seqs
; restricted - 
(ns offline-4clojure.p44
  (:use clojure.test))

(def __
  (fn [unmoddedcnt col]
    (let [cnt (mod unmoddedcnt (count col))]
    (cond (>= cnt 0) (let [split (split-at cnt col)] (concat (second split) (first split)))
          :else (let [split (split-at (+ (count col) cnt) col)] (concat (second split) (first split))))))
)

(defn -main []
  (are [x] x
(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
(= (__ 1 '(:a :b :c)) '(:b :c :a))
(= (__ -4 '(:a :b :c)) '(:c :a :b))
))
