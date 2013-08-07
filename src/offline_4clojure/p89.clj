; Graph Tour - Hard
; Starting with a graph you must write a function that returns true if it is possible to make a tour of the graph in which every edge is visited exactly once.<br/><br/>The graph is represented by a vector of tuples, where each tuple represents a single edge.<br/><br/>The rules are:<br/><br/>- You can start at any node.<br/>- You must visit each edge exactly once.</br>- All edges are undirected.
; tags - graph-theory
; restricted - 
(ns offline-4clojure.p89
  (:use clojure.test))

(def __
  (fn [edge-vecs]
    (let [all-edges (map set edge-vecs)
          path-freq #(frequencies (map set %))
          tour-freqs (frequencies all-edges)
          tour? (fn [path] (= (path-freq path) tour-freqs))
          step (fn [path]
                 (let [path-freqs (path-freq path)
                       required-edge (fn [edge] 
                                       (< (path-freqs edge 0)
                                          (tour-freqs edge)))
                       required-edges (set (filter required-edge all-edges))
                       current-node (last (last path))
                       allowed-edge (fn [edge] (edge current-node))
                       allowed-edges (filter allowed-edge required-edges)
                       next-node (fn [edge] (if (= 1 (count edge))
                                              (first edge)
                                              (first (filter (partial not= current-node) edge))))]
                   (map #(conj path [current-node (next-node %)]) allowed-edges)))
          starting-paths (set (mapcat
                                #(vector [[(first %) (second %)]] [[(second %) (first %)]])
                                edge-vecs))]
      (loop [paths starting-paths]
        (if (some tour? paths)
          true
          (let [stepped-paths (set (mapcat step paths))]
            (if (= paths stepped-paths)
              false
              (recur stepped-paths)))))))
)

(defn -main []
  (are [x] x
(= true (__ [[:a :b]]))
(= false (__ [[:a :a] [:b :b]]))
(= false (__ [[:a :b] [:a :b] [:a :c] [:c :a]
               [:a :d] [:b :d] [:c :d]]))
(= true (__ [[1 2] [2 3] [3 4] [4 1]]))
(= true (__ [[:a :b] [:a :c] [:c :b] [:a :e]
              [:b :e] [:a :d] [:b :d] [:c :e]
              [:d :e] [:c :f] [:d :f]]))
(= false (__ [[1 2] [2 3] [2 4] [2 5]]))
))
