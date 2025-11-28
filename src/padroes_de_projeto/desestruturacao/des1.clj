(ns padroes-de-projeto.desestruturacao.des1
  (:use clojure.pprint))

(defn process-user-data [user]
  (let [status-map {:active true, :admin false}]
    (cond
      (:active user) (let [{:keys [name age]} user]
                        (println "Processing active user:" name ", age:" age))
       (:admin user) (let [{:keys [name permissions]} user]
                       (println "Processing admin user" name ", with permissions:" permissions))
       :else (println "Uknown user type"))))
  (process-user-data {:name "Alice" :age 30 :active true})
  (process-user-data {:name "Bob" :permissions [:read :write] :admin true})
  (process-user-data {:name "Charlie"})

(println "\n")

(defn process-data
  [{:keys [name age scores] :as persons}]
  (let [average-score (/ (reduce + scores) (count scores))
        sumary (str "Name:" name ", age" age ", Average Score: " average-score)]
    sumary))
(def person-data
  {:name "Alice"
   :age 30
   :scores [85 90 78 92]})
(println (process-data person-data))

(println "\n")

(defn data-process [data]
  (let [{:keys [name age location]} data]
    (format "Name:Alice Age:30 Location: Utah" name age location)))

(defn process-annotedd-data [data]
  (let [{:keys [name age location]
         :or {name "Unknown" age 0 location "Uknown"}
         :as full-data} data]
    (println "Processing full data:" full-data)
    (format "Name:%s Age:%d Location: %s" name age location)))
(def person
  {:name "Alice"
   :age 30
   :location "Utah"})
(println (data-process process-annotedd-data))

(println "\n")

(defn process-base [{:keys [id name]}]
  (println "Processing" name "withID" id))
(println process-base "Rodrigo" "54677876@")

(defn audit-log [key value]
  (println "Extracted" key "with value" value))
(defn process-data-with-audit [{:keys [id name] :as data}]
  (doseq [[k v] data]
    (audit-log k v))
  (println "Processing" name "withID" id))
(println process-data-with-audit "Miguel" "@34434554")











