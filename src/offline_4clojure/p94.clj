; Game of Life - Hard
; The <a href="http://en.wikipedia.org/wiki/Conway's_Game_of_Life">game of life</a> is a cellular automaton devised by mathematician John Conway. <br/><br/>The 'board' consists of both live (#) and dead ( ) cells. Each cell interacts with its eight neighbours (horizontal, vertical, diagonal), and its next state is dependent on the following rules:<br/><br/>1) Any live cell with fewer than two live neighbours dies, as if caused by under-population.<br/>2) Any live cell with two or three live neighbours lives on to the next generation.<br/>3) Any live cell with more than three live neighbours dies, as if by overcrowding.<br/>4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.<br/><br/>Write a function that accepts a board, and returns a board representing the next generation of cells.
; tags - game
; restricted - 
(ns offline-4clojure.p94
  (:use clojure.test))

(def __
  (fn gol-step [board]
    (letfn [(cell [x y] (get (board y) x))
            (out-of-bounds? [x y] (or (< x 0) (< y 0)))
            (neighbours [x y] 
              (filter #(not (apply out-of-bounds? %))
                      [[(- x 1) (- y 1)] [x (- y 1)] [(+ x 1) (- y 1)]
                       [(- x 1) y]       ,,,,,,,,,,, [(+ x 1) y]
                       [(- x 1) (+ y 1)] [x (+ y 1)] [(+ x 1) (+ y 1)]]))
            (step-cell [x y]
              (prn "zomg" x y)
              (let [neighbour-cells (map #(apply cell %) (neighbours x y))
                    alive-neighbours (count (filter (partial = \#) neighbour-cells))]
                (prn "here")
                (prn (neighbours x y))
                (prn neighbour-cells)
                (prn alive-neighbours)
                (prn (cell x y))
                (if (= \# (cell x y))
                  (cond
                    (< alive-neighbours 2) \space
                    (< alive-neighbours 4) \#
                    :else \space)
                  (if (= alive-neighbours 3) \# \space))))]
      (map-indexed 
        (fn [j row]
          (prn "row: " j)
          (map-indexed 
            (fn [i _]
              (prn "col: " i)
              (step-cell i j)) row)) board)))
)

(defn -main []
  (are [x] x
(= (__ ["      "  
        " ##   "
        " ##   "
        "   ## "
        "   ## "
        "      "])
   ["      "  
    " ##   "
    " #    "
    "    # "
    "   ## "
    "      "])
(= (__ ["     "
        "     "
        " ### "
        "     "
        "     "])
   ["     "
    "  #  "
    "  #  "
    "  #  "
    "     "])
(= (__ ["      "
        "      "
        "  ### "
        " ###  "
        "      "
        "      "])
   ["      "
    "   #  "
    " #  # "
    " #  # "
    "  #   "
    "      "])
))
