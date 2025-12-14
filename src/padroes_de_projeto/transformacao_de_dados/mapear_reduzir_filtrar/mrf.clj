(ns padroes-de-projeto.transformacao-de-dados.mapear-reduzir-filtrar.mrf)

(defn sum [numbers]
  (println "Somamdo Coleções")
  (reduce + 0 numbers))
(println(sum [1 2 3 4 5]))

(defn frequency [coll]
  (println "Frequência de contagem")
  (reduce (fn [counts item]
            (update counts item (fnil inc 0)))
          {}
          coll))
(println (frequency [:a :b :c :d :e]))

(defn average [numbers]
  (println "Calculando a média")
  (let [{:keys [sum count]}
        (reduce (fn [{:keys [sum count]} n]
                  {:sum (+ sum n), :count (inc count)})
                {:sum 0, :count 0}
                numbers)]
    (/ sum count)))
(println (average [10 20 30 40 50]))

(defn conditional-reduce [coll]
  (println "Reduções condicionais")
  (reduce (fn [acc x]
            (if (even? x)
              (+ acc x) acc))
          0
          coll))

(println (conditional-reduce [1 2 3 4 5 6 7 8 9 10]))


(defn sum-of-list [numbers]
  (println "Redução cumulativa")
  (reduce + 0 numbers))

(def nums [1 2 3 4 5])
  (println (sum-of-list nums))


(defn multiply-positives
  "Redutor personalizado para multiplicar apenas os números positivos em uma coleção."
  [accumalator item]
  (println "Redutores personalizados")
  (if (pos? item)
    (* accumalator item)
    accumalator))

(defn reduce-produtive-product [coll]
  (reduce multiply-positives 1 coll))

(println (reduce-produtive-product [1 -2 3 -4 5]))



