(ns climbing-stairs.core)

(def question
  ["You are climbing a stair case. It takes n steps to reach to the top.
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?"
  "Turns out that the trick is that it's Fib, lol"])


(defn fib-seq []
  (lazy-cat [0 1] (map + (rest fib-seq) fib-seq)))

(defn climb-stairs
  [int]
  (let [patterns (-> #{int}
                     (conj (/ int 2)))
        distinct (take int fib-seq)
        patterns (map #(conj patterns %) disinct)]
    (if (= patterns #{0})
      0
      (count patterns))))
