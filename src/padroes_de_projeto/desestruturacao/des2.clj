(ns padroes-de-projeto.desestruturacao.des2
  (:require [clojure.core.match :as match]))

(defn process-user-data-match [user]
  (match/match [user]
         [{:active true :name name :age age}]
         (println "Processing active user" name ", age:" age )

         [{:admin true :name name :permissions permissions}]
         (println "Processing admin user" name ", with permissions:" permissions)
         :else
         (println "Uknown user type")))
(process-user-data-match {:name "Alice" :age 30 :active true})
(process-user-data-match {:name "Bob" :permissions [:read :write] :admin true})
(process-user-data-match {:name "Charlie"})
