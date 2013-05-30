; Flatten a Sequence - Easy
; Write a function which flattens a sequence.
; tags - seqs:core-functions
; restricted - flatten
(ns offline-4clojure.p28
  (:use clojure.test))

(def __
  (letfn [(f [acc s] (reduce g acc s))
          (g [acc item]
              (cond
                (sequential? item) (f acc item)
                :else (cons item acc)))] 
    #(reverse (f () %)))
)

(defn -main []
  (are [x] x
(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
(= (__ '((((:a))))) '(:a))
))
