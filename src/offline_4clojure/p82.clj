; Word Chains - Hard
; A word chain consists of a set of words ordered so that each word differs by only one letter from the words directly before and after it.  The one letter difference can be either an insertion, a deletion, or a substitution.  Here is an example word chain:<br/><br/>cat -> cot -> coat -> oat -> hat -> hot -> hog -> dog<br/><br/>Write a function which takes a sequence of words, and returns true if they can be arranged into one continous word chain, and false if they cannot.
; tags - seqs
; restricted - 
(ns offline-4clojure.p82
  (:use clojure.test))

(def __
  (fn [words]
    (letfn [(w-o [s el]
              (filter #(not (= el %)) s))
            (one-letter-different? [a b]
              (letfn [(differ [[a & as] [b & bs] single-diff?]
                        (if (and (nil? a) (nil? b))
                          single-diff?
                          (if (= a b)
                            (differ as bs single-diff?)
                            (if single-diff?
                              false
                              (or (differ as (cons b bs) true)
                                  (differ (cons a as) bs true)
                                  (differ as bs true))))))]
                (differ a b false)))
            (check-potentials [potentials others]
              (if (empty? potentials)
                false
                (not (nil? (some #(can-form-chain? % (w-o others %)) potentials)))))
            (can-form-chain? [target others]
              (if (empty? others)
                true
                (let [potentials (filter #(one-letter-different? target %) others)]
                  (check-potentials potentials others))))]
      (check-potentials words words)))
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



;(defn -main []
;  (are [x] x
;       (= false (one-letter-different? "hello" "hello"))
;       (= true (one-letter-different? "hello" "hellr"))
;       (= true (one-letter-different? "hello" "hell"))
;       (= true (one-letter-different? "hello" "helo"))
;       (= true (one-letter-different? "hello" "helloo"))
;       (= true (one-letter-different? "hello" "helloz"))
;       (= false (one-letter-different? "hello" "helloze"))
;       (= false (one-letter-different? "hello" "hlo"))
;       (= false (one-letter-different? "hello" "ehlo"))))
