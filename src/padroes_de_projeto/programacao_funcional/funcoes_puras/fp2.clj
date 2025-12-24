(ns padroes-de-projeto.programacao-funcional.funcoes-puras.fp2)

(defn calculate-interest [principal rate time]
  (* principal rate time))
(defn compute-interests [accounts]
  (pmap (fn [{:keys [principal rate time]}]
          {:account-interest (calculate-interest principal rate time)})
        accounts))

(def accounts [{:principal 1000, :rate 0.05, :time 1}
               {:principal 1500, :rate 0.045, :time 2}])
(def interests (compute-interests accounts))

(println interests)



