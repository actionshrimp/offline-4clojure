; Pascal's Triangle - Easy
; <a href="http://en.wikipedia.org/wiki/Pascal%27s_triangle">Pascal's triangle</a> is a triangle of numbers computed using the following rules:<br/></br>- The first row is 1.</br>- Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.<br/><br/>Write a function which returns the nth row of Pascal's Triangle.
;
;
;
; tags - 
; restricted - 
(ns offline-4clojure.p97
  (:use clojure.test))

(def __
  (fn pascal-row [n]
    (cond (= n 1) [1]
          (= n 2) [1 1]
          :else (concat
                  [1] 
                  (let [prev-row (pascal-row (- n 1))]
                    (reduce #(concat (butlast %1)
                                     [(+ (last %1) %2)]
                                     [%2])
                      [(first prev-row)]
                      (rest prev-row))))))
)

(defn -main []
  (are [x] x
(= (__ 1) [1])
(= (map __ (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])
(= (__ 11)
   [1 10 45 120 210 252 210 120 45 10 1])
))
