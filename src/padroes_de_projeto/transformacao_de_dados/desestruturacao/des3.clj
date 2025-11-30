(ns padroes-de-projeto.transformacao-de-dados.desestruturacao.des3
  (:use clojure.pprint)
  (:import (java.security.interfaces DSAPublicKey)))

(defn process-data
  [{:keys [name age scores] :as person}]
  (let [average-score (/ (reduce + scores) (count scores))
        sumary (str "Name: " name ", Age: " age " Average score: " average-score)]
    sumary))

(def person-data
  {:name "Alice"
   :age 39
   :scores [85 90 78 92]})
(pprint (process-data person-data))


(defn process-data [data]
  (let [{:keys [name age location]} data]
    (format "Name: %s, Age: %d, Locationn: %s" name age location)))

(defn process-annotated-data [data]
  (let [{:keys [name age location]
         :or {name "Uknown" age 0 location "Uknown"}
         :as full-data} data]
    (println "Processing full data:" full-data)
    (format "Name: %s, Age: %d, Locationn: %s" name age location)))

(def sample-data
  {:name "Alice"
   :age 39
   :location "São Paulo"})

(pprint (process-data sample-data))
(pprint (process-annotated-data sample-data))
