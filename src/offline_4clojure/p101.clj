; Levenshtein Distance - Hard
; Given two sequences x and y, calculate the <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Levenshtein_distance">Levenshtein distance</a> of x and y, i. e. the minimum number of edits needed to transform x into y.  The allowed edits are:<br/><br/>- insert a single item<br/>- delete a single item<br/>- replace a single item with another item<br/><br/>WARNING: Some of the test cases may timeout if you write an inefficient solution!
; tags - seqs
; restricted - 
(ns offline-4clojure.p101
  (:use clojure.test))

(def __
  (fn [a b]
    (let [worker (fn [lev a b]
                   (cond (nil? a) (count b)
                         (nil? b) (count a)
                         :else
                         (let [cost (if (= (last a) (last b)) 0 1)]
                           (min (+ (lev lev (butlast a) b) 1)
                                (+ (lev lev a (butlast b)) 1)
                                (+ (lev lev (butlast a) (butlast b)) cost)))))
          lev (memoize worker)]
      (lev lev a b)))
)

(defn -main []
  (are [x] x
(= (__ "kitten" "sitting") 3)
(= (__ "closure" "clojure") (__ "clojure" "closure") 1)
(= (__ "xyx" "xyyyx") 2)
(= (__ "" "123456") 6)
(= (__ "Clojure" "Clojure") (__ "" "") (__ [] []) 0)
(= (__ [1 2 3 4] [0 2 3 4 5]) 2)
(= (__ '(:a :b :c :d) '(:a :d)) 2)
(= (__ "ttttattttctg" "tcaaccctaccat") 10)
(= (__ "gaattctaatctc" "caaacaaaaaattt") 9)
))
