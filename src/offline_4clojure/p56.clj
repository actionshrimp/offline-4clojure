; Find Distinct Items - Medium
; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
; tags - seqs:core-functions
; restricted - distinct
(ns offline-4clojure.p56
  (:use clojure.test))

(def __
  #(reduce (fn [acc x]
            (if (some #{x} acc)
              acc
              (concat acc (list x))))
          ()
          %)
)

(defn -main []
  (are [x] x
(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
(= (__ [:a :a :b :b :c :c]) [:a :b :c])
(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (__ (range 50)) (range 50))
))
