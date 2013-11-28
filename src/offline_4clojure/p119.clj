; Win at Tic-Tac-Toe - Hard
; <p>As in <a href="/problem/73">Problem 73</a>, a tic-tac-toe board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e. Create a function that accepts a game piece and board as arguments, and returns a set (possibly empty) of all valid board placements of the game piece which would result in an immediate win.</p>
;
;<p>Board coordinates should be as in calls to <code>get-in</code>. For example, <code>[0 1]</code> is the topmost row, center position.</p>
; tags - game
; restricted - 
(ns offline-4clojure.p119
  (:use clojure.test))

(def __
  (fn [p b]
    (let [all-moves #{[0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2]} 
          allowed? #(= :e (get-in b %))
          new-board-for #(assoc-in b % p)
          are-all-p #(= [p p p] %)
          as-cols #(apply (partial map vector) %)
          pieces-at (fn [b coords] (map #(get-in b %) coords))
          has-winning-row? #(some are-all-p %)
          has-winning-col? #(some are-all-p (as-cols %))
          has-winning-diagonal? #(or (are-all-p (pieces-at % [[0 0] [1 1] [2 2]]))
                                     (are-all-p (pieces-at % [[0 2] [1 1] [2 0]])))
          winning? #(some identity
                      ((juxt
                         has-winning-row?
                         has-winning-col?
                         has-winning-diagonal?)
                       (new-board-for %)))]
      (set 
        (filter winning? 
                (filter allowed? all-moves)))))
)

(defn -main []
  (are [x] x
(= (__ :x [[:o :e :e] 
           [:o :x :o] 
           [:x :x :e]])
   #{[2 2] [0 1] [0 2]})
(= (__ :x [[:x :o :o] 
           [:x :x :e] 
           [:e :o :e]])
   #{[2 2] [1 2] [2 0]})
(= (__ :x [[:x :e :x] 
           [:o :x :o] 
           [:e :o :e]])
   #{[2 2] [0 1] [2 0]})
(= (__ :x [[:x :x :o] 
           [:e :e :e] 
           [:e :e :e]])
   #{})
(= (__ :o [[:x :x :o] 
           [:o :e :o] 
           [:x :e :e]])
   #{[2 2] [1 1]})
))
