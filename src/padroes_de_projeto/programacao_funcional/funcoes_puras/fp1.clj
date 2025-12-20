(ns padroes-de-projeto.programacao-funcional.funcoes-puras.fp1)

(defn add [x y]
  (+ x y))

(defn factorial [n]
  (reduce *(range 1 (inc n))))

(defn calculate [a b]
  (println "Previsibilidade Comportamental")
  (let [sum (add a b) fact (factorial sum)]
    fact))
(println (calculate 3 4))

(println "\nProgramação")

(defn add-one [x]
  (+ x 1))
(defn square [x]
  (* x x))

(defn is-even? [x]
  (zero? (mod x 2)))

(defn process-number [x]
  (println "Composibilidade")
  ((comp is-even? square add-one) x))

(println (process-number 3))
(println (process-number 2))

(println "\nFuncional")

(defn increment [x]
  (+ x 1))
(defn capitalize [str]
  (.toUpperCase str))

(defn transform-data [data]
  (println "Transformação de dados")
  (map (fn [entry]
         {:id (increment (:id entry))
          :name (capitalize (:name entry))})
       data))

(def sample-data [{:id 1 :name "miguel"}
                  {:id 2 :name "maria"}
                  {:id 3 :name "sofia"}])

(println (transform-data sample-data))




