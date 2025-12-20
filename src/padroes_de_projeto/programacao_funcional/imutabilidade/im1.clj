(ns padroes-de-projeto.programacao-funcional.imutabilidade.im1)

(defn update-user-age [users user-id new-age]
  (assoc-in users [user-id :age] new-age))

(def users
  {:user1 {:name "Alice" :age 30}
   :user2 {:name "Bob" :age 25}})









