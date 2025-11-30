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

(defn conditional-transform [pred-fn transforn-map data]
  ((println "Mapeamento Condicional")
   (map (fn [item]
          (let [transform-fn (first (filter
                                      (fn [[pred _]]
                                        (pred item))
                                      transforn-map))]
            (if transform-fn
              ((second transform-fn) item)
              item)))
        data)))

(defn gt-10? [x] (> x 10))
(defn lt-5? [x] (< x 5))

(defn incr [x] (+ x 1))
(defn decr [x] (- x 1))

(def sample-data [3 7 11 2 15 6])

(def transformed-data
  (conditional-transform
    [[gt-10? decr]
     [lt-5? incr]]
    sample-data))
(println transformed-data)













