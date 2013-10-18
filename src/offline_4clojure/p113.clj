; Making Data Dance - Hard
; Write a function that takes a variable number of integer arguments.  If the output is coerced into a string, it should return a comma (and space) separated list of the inputs sorted smallest to largest.  If the output is coerced into a sequence, it should return a seq of unique input elements in the same order as they were entered.
; tags - types
; restricted - proxy
(ns offline-4clojure.p113
  (:use clojure.test))

(def __
(fn [& args]
  (reify clojure.lang.Seqable
    (toString [this] 
      (clojure.string/join ", " (sort args)))
    (seq [this] 
      (seq (distinct args)))))
)

(clojure.string/join ", " [1 2 3])

(defn -main []
  (are [x] x
(= "1, 2, 3" (str (__ 2 1 3)))
(= '(2 1 3) (seq (__ 2 1 3)))
(= '(2 1 3) (seq (__ 2 1 3 3 1 2)))
(= '(1) (seq (apply __ (repeat 5 1))))
(= "1, 1, 1, 1, 1" (str (apply __ (repeat 5 1))))
(and (= nil (seq (__)))
     (=  "" (str (__))))
))

(-main)
