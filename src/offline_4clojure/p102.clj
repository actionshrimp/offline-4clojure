; intoCamelCase - Medium
; When working with java, you often need to create an object with <code>fieldsLikeThis</code>, but you'd rather work with a hashmap that has <code>:keys-like-this</code> until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.
; tags - strings
; restricted - 
(ns offline-4clojure.p102
  (:use clojure.test))

(def __
  (fn [w] 
    (apply str
           (reduce 
             (fn [acc x]
               (if (= \- (last acc))
                 (conj (vec (butlast acc)) (Character/toUpperCase x))
                 (conj acc x)))
             [] w)))
)

(defn -main []
  (are [x] x
(= (__ "something") "something")
(= (__ "multi-word-key") "multiWordKey")
(= (__ "leaveMeAlone") "leaveMeAlone")
))
