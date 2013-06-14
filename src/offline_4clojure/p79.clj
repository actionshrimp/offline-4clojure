; Triangle Minimal Path - Hard
; Write a function which calculates the sum of the minimal path through a triangle.  The triangle is represented as a collection of vectors.  The path should start at the top of the triangle and move to an adjacent number on the next row until the bottom of the triangle is reached.
; tags - graph-theory
; restricted - 
(ns offline-4clojure.p79
  (:use clojure.test))

(def __ 
  (fn [t]
    (letfn [(all-paths-for [num-rows]
             (map reverse (loop [paths [()] current-row 1]
               (if (> current-row num-rows) 
                 paths
                 (recur
                   (mapcat (fn [i] (map #(conj % i) paths)) (range current-row))
                   (inc current-row))))))
            (valid-path? [p] 
              (get (reduce #(if (or (= (get % :last) %2) (= (+ 1 (get % :last)) %2)) 
                              {:valid? (get % :valid?) :last %2}
                              {:valid? false :last %2}) 
                           {:valid? true :last (first p)}
                           (rest p)) :valid?))
            (valid-paths-for [num-rows] 
              (filter valid-path? (all-paths-for num-rows)))
            (cost-of-path [p]
              (apply + (map #(get %1 %2) t p)))]
      (->> (valid-paths-for (count t))
        (map cost-of-path)
        (sort)
        (first))))
  )

(defn -main []
  (are [x] x
(= 7 (__ '([1]
          [2 4]
         [5 1 4]
        [2 3 4 5]))) ; 1->2->1->3
(= 20 (__ '([3]
           [2 4]
          [1 9 3]
         [9 9 2 4]
        [4 6 6 7 8]
       [5 7 3 5 1 4]))) ; 3->4->3->2->7->1
))

(-main)
