(ns same-tree.core)

(def tree-1
  {:val 1
   :left {:val 2
          :left {:val 3
                 :left {:val 11
                        :left {:val 15
                               :left {:val 100
                                      :left {:val 2
                                             :left {:val 1}}
                                      :right {:val 1}}
                               :right {:val 100}}
                        :right {:val 16
                                :left {:val 12}
                                :right {:val 99}}}
                 :right {:val 5}}}
   :right {:val 4
           :left {:val 10}
           :right {:val 6}}})

(def tree-2
  {:val 1
   :left {:val 2
          :left {:val 3
                 :left {:val 11
                        :left {:val 15
                               :left {:val 100
                                      :left {:val 2
                                             :left {:val 1}}}
                               :right {:val 100}}}
                 :right {:val 5}}}
   :right {:val 4
           :left {:val 10}}})

(defn same?
  [p q]
  (cond
    (and (nil? p) (nil? q)) true
    (= (:val p) (:val q)) (and (same? (:left p) (:left q))
                               (same? (:right p) (:right q)))
    :else false))
