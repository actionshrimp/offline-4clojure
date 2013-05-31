; Let it Be - Elementary
; Can you bind x, y, and z so that these are all true?
; tags - math:syntax
; restricted - 
(ns offline-4clojure.p36
  (:use clojure.test))

(def __
[z 1 y 3 x 7]
)

(defn -main []
  (are [x] x
(= 10 (let __ (+ x y)))
(= 4 (let __ (+ y z)))
(= 1 (let __ z))
))
