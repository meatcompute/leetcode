(ns max-depth-binary-tree.core)

(def tree
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


(defn max-depth
  "Recursively follows a tree down the left sides then walks back up resolving and comparing to the
  depth of each right branch."
  [{:keys [left right] :as root}]
  (if-not (nil? root)
    (let [left (max-depth left)
          right (max-depth right)]
      (inc (Math/max left right)))
    0))
