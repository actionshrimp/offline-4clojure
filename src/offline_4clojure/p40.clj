; Interpose a Seq - Easy
; Write a function which separates the items of a sequence by an arbitrary value.
; tags - seqs:core-functions
; restricted - interpose
(ns offline-4clojure.p40
  (:use clojure.test))

(def __
  (fn [sep xs]
    (concat (list (first xs)) (mapcat #(list sep %) (rest xs))))
)

(defn -main []
  (are [x] x
(= (__ 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
(= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
))
