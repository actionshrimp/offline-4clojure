; Word Chains - Hard
; A word chain consists of a set of words ordered so that each word differs by only one letter from the words directly before and after it.  The one letter difference can be either an insertion, a deletion, or a substitution.  Here is an example word chain:<br/><br/>cat -> cot -> coat -> oat -> hat -> hot -> hog -> dog<br/><br/>Write a function which takes a sequence of words, and returns true if they can be arranged into one continous word chain, and false if they cannot.
; tags - seqs
; restricted - 
(ns offline-4clojure.p82
  (:use clojure.test))

(def __
  (fn [words]
    (letfn [(w-o [s el]
              (clojure.set/difference s #{el}))
            (attempt [start remaining]
              (if (empty? remaining)
                true
                (let [potentials (filter (partial one-letter-different? start) remaining)]
                  (if (empty? potentials)
                    false
                    (some identity (map #(attempt % (w-o potentials %)) potentials))))))]
      (some identity (map #(attempt % (w-o words %)) words))))
)

(defn -main []
  (are [x] x
(= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))
(= false (__ #{"cot" "hot" "bat" "fat"}))
(= false (__ #{"to" "top" "stop" "tops" "toss"}))
(= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"}))
(= true (__ #{"share" "hares" "shares" "hare" "are"}))
(= false (__ #{"share" "hares" "hare" "are"}))
))

(-main)

            ((defn one-letter-different? [a b]
              (let [fa (frequencies a)
                    fb (frequencies b)
                    differ (fn [acc [letter to-sub]]
                             (let [do-sub (fnil (fn [old-count] (- old-count to-sub)) 0)]
                               (update-in acc [letter] do-sub))) 
                    diff (reduce differ fa fb)
                    diff-vals (vals diff)
                    absed-vals (map #(if (< % 0) (-%) %) diff-vals)
                    diff-vals-sum (apply + diff-vals)
                    absed-vals-sum (apply + absed-vals)]
                (and (or (= 1 diff-vals-sum) (= 0 diff-vals-sum))
                     (or (= 1 absed-vals-sum) (= 2 absed-vals-sum))))) "hello" "hellor")
