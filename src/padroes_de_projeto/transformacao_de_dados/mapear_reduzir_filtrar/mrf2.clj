(ns padroes-de-projeto.transformacao-de-dados.mapear-reduzir-filtrar.mrf2)

(defn filter-with-index [pred coll]
  (println "Filtrar com indexação")
  (->> coll
      (map-indexed vector)
      (filter (fn [[idx val]] (pred idx val)))
      (map second)))
(def sample-coll ["apple" "banana" "cherry" "date" "elderberry"])

(defn even-index-predicate [idx val]
  (even? idx))
(println (filter-with-index even-index-predicate sample-coll))

(println "\nFiltro com transdutores")

(def even-xf (filter even?))
(def numbers (range 10))
(def filtered-evens (sequence even-xf numbers))
(println filtered-evens)

(println "\nFiltrar e mapear")

(def numbers [1 2 3 4 5 6 7 8 9 10])
(defn filter-map-combo [coll]
  (println "Combinação de filtro e mapa")
  (->> coll
       (filter odd?)
       (map #(* % %))))
(println (filter-map-combo numbers))

(println "\nFiltrar")

(defn even-numbers [nums]
  (println "Filtragem de dados")
  (filter even? nums))
(println (even-numbers [1 2 3 4 5 6 7 8 9 10]))

(println "\nMapeamento plano")

(defn flat-map [f coll]
  (println "Mapeamento plano")
  (apply concat (map f coll)))

(def nested-coll [[1 2] [3 4] [5 6]])

(println (flat-map (fn [x] (map inc x)) nested-coll))

