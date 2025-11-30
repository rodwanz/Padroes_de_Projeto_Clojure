(ns padroes-de-projeto.transformacao-de-dados.mapeamento-e-projecao-de-dados.mpd1
    (:require [clojure.core.reducers :as r]))

(defn map-with-agreggation [f agg initial coll]
      (r/reduce
        (fn [acc el]
            (agg acc (f el)))
        initial coll))

(def employees
  [{:name "Alice" :salary 70000}
   {:name "Bob" :salary 55000}
   {:name "Charlie" :salary 105000}
   {:name "David" :salary 80000}])

(defn salary-plus-bonnus [employee]
      (+ (:salary employee) 5000))

(defn sum-salaries [total salary]
      (+ total salary))

(def total-salarie-with-bonus
  (map-with-agreggation salary-plus-bonnus sum-salaries 0 employees))

(println "Total salaries with bonus:" total-salarie-with-bonus)

