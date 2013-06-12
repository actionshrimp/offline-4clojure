; Analyze a Tic-Tac-Toe Board - Hard
; A <a href="http://en.wikipedia.org/wiki/Tic-tac-toe">tic-tac-toe</a> board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e.  A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.  Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.
; tags - game
; restricted - 
(ns offline-4clojure.p73
  (:use clojure.test))

(def __ 
  (fn [board]
    (letfn [
            (has-winner [coll] (some #(if (not (or (nil? %) (= :e %))) % false) coll))
            (row-winner [r] (if (apply = r) (first r) nil))
            (transpose [b] (apply mapv vector b))
            (winner-by-row [b] (has-winner (map row-winner b)))
            (winner-by-col [b] (winner-by-row (transpose b)))
            (winner-by-diag [b] (has-winner (list (if (or (= (get (get b 0) 0) (get (get b 1) 1) (get (get b 2) 2))
                                         (= (get (get b 0) 2) (get (get b 1) 1) (get (get b 2) 0)))
                                  (get (get b 1) 1) nil))))]
      (some identity [(winner-by-row board) (winner-by-col board) (winner-by-diag board)])))
  )

(defn -main []
  (are [x] x
       (= nil (__ [[:e :e :e]
                   [:e :e :e]
                   [:e :e :e]]))
       (= :x (__ [[:x :e :o]
                  [:x :e :e]
                  [:x :e :o]]))
       (= :o (__ [[:e :x :e]
                  [:o :o :o]
                  [:x :e :x]]))
       (= nil (__ [[:x :e :o]
                   [:x :x :e]
                   [:o :x :o]]))
       (= :x (__ [[:x :e :e]
                  [:o :x :e]
                  [:o :e :x]]))
       (= :o (__ [[:x :e :o]
                  [:x :o :e]
                  [:o :e :x]]))
       (= nil (__ [[:x :o :x]
                   [:x :o :x]
                   [:o :x :o]]))
       ))

(-main)
