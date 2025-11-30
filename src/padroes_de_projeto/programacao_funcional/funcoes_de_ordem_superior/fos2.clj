(ns padroes-de-projeto.programacao-funcional.funcoes-de-ordem-superior.fos2)

(println "\nPadrão de retorno de chamada")

(defn fetch-data-async [url sucess-callback error-callback]
  (future
    (try
      (Thread/sleep 1000)
      (if (.startsWith url "http")
        (sucess-callback {:data "Server response data"})
        (throw (Exception. "Invalid URL format")))
      (catch Exception e
             (error-callback (.getMessage e))))))

(defn handle-sucess [response]
  (println "Data fetched sucessfuly: " response))

(defn handle-error [error]
  (println "failed to fetched data: " error))

(fetch-data-async "http://example.com" handle-sucess handle-error)
(fetch-data-async "Invalid-url" handle-sucess handle-error)

