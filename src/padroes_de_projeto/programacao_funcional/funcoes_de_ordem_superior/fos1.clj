(ns padroes-de-projeto.programacao-funcional.funcoes-de-ordem-superior.fos1)

(println "\nProgramação Orientada a Aspectos")

(defn log-wrapper [f]
  (fn [& args]
    (println "Calling function with args: " args)
    (let [result (apply f args)]
      (println "Function retorned: " result)
      result)))

(defn add [x y]
  (+ x y))

(def logged-add (log-wrapper add))
(logged-add 3 4)

(println "\nUtilizando macros para questões transversais mais complexas")

(defmacro time-execution [expr]
  `(let [start# (System/nanoTime)
        result# ~expr
        end# (System/nanoTime)]
    (println "Execution Time: " (/ (- end# start#) 1e6) "ms")
    result#))
(time-execution (Thread/sleep 1000))

(println "\nUtilitários Componíveis")

(defn double-it [x]
  (* x 2))

(defn is-even? [x]
  (zero? (mod x 2)))

(def transform-and-filter
  (comp (partial filter is-even?)
        (partial map double-it)))

(def imput-data [1 2 3 4 5 6])
(def result (transform-and-filter imput-data))
(println result)
