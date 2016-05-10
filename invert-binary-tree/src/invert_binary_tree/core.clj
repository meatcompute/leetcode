(ns invert-binary-tree.core)

;; A sub-tree's key being nil is the same as not setting the key thanks to Clojure's destructuring semantics.
(def tree
  {:val 1
   :left {:val 2
          :left {:val 3
                 :left {:val 11
                        :left {:val 15
                               :left {:val 100}
                               :right {:val 100}}
                        :right {:val 16
                                :left {:val 12}
                                :right {:val 99}}}
                 :right {:val 5}}}
   :right {:val 4
           :left {:val 10}
           :right {:val 6}}})

(defn invert
  "Takes a recursive binary tree like above and returns the inverse."
  [{:keys [left right] :as node}]
  (when-not (nil? node)
    (let [right (invert right)
          left (invert left)]
      (assoc node
             :left right
             :right left))))
