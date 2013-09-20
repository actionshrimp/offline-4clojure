; Identify keys and values - Medium
; Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the value is a sequence of all the numbers (if any) between it and the next keyword in the sequence.
; tags - maps:seqs
; restricted - 
(ns offline-4clojure.p105
  (:use clojure.test))

(def __
  (fn [xs]
    (reduce #(if (keyword? %2)
                 (assoc %1 %2 [])
                 (assoc %1 (first (last %1)) (conj (second (last %1)) %2)))
            (sorted-map) xs))
)

(defn -main []
  (are [x] x
(= {} (__ []))
(= {:a [1]} (__ [:a 1]))
(= {:a [1], :b [2]} (__ [:a 1, :b 2]))
(= {:a [1 2 3], :b [], :c [4]} (__ [:a 1 2 3 :b :c 4]))
))
