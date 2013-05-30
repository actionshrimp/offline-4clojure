; Fibonacci Sequence - Easy
; Write a function which returns the first X fibonacci numbers.
; tags - Fibonacci:seqs
; restricted - 
(ns offline-4clojure.p26
  (:use clojure.test))

(def __
  (let [calc-next (fn [current] 
               (let [len (count current)]
                 (cond
                   (or (= 0 len) (= 1 len)) 1
                   :else (apply + (take 2 current)))))
        iter (fn [f cnt acc]
               (cond 
                 (= cnt 0) (reverse acc)
                 :else (f f (- cnt 1) (cons (calc-next acc) acc))))]
    (fn [x] (iter iter x ())))
)

(defn -main []
  (are [x] x
(= (__ 3) '(1 1 2))
(= (__ 6) '(1 1 2 3 5 8))
(= (__ 8) '(1 1 2 3 5 8 13 21))
))
