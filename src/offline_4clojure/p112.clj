; Sequs Horribilis - Medium
; Create a function which takes an integer and a nested collection of integers as arguments.  Analyze the elements of the input collection and return a sequence which maintains the nested structure, and which includes all elements starting from the head whose sum is less than or equal to the input integer.
; tags - seqs
; restricted - 
(ns offline-4clojure.p112
  (:use clojure.test))

(def __
(fn [i xs]
  (:ys
    ((fn f 
       ([i xs] (f i xs {:total 0 :ys []}))
       ([i [x & xs] acc] 
        (if-not (nil? x)
          (if-not (sequential? x)
            (if-not (> x i)
              (recur (- i x) xs {:total (+ (acc :total) x) :ys (conj (acc :ys) x)})
              acc)
            (let [sub (f i x)]
              (recur (- i (sub :total)) xs {:total (+ (acc :total) (sub :total)) :ys (conj (acc :ys) (sub :ys))})))
          acc)))
     i xs)))
)

(defn -main []
  (are [x] x
(=  (__ 10 [1 2 [3 [4 5] 6] 7])
   '(1 2 (3 (4))))
(=  (__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
   '(1 2 (3 (4 (5 (6 (7)))))))
(=  (__ 9 (range))
   '(0 1 2 3))
(=  (__ 1 [[[[[1]]]]])
   '(((((1))))))
(=  (__ 0 [1 2 [3 [4 5] 6] 7])
   '())
(=  (__ 0 [0 0 [0 [0]]])
   '(0 0 (0 (0))))
(=  (__ 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
   '(-10 (1 (2 3 (4)))))
))

(-main)
