(ns poolr.api.core
  (:use
   net.cgrand.moustache
   ring.middleware.params
   ring.adapter.jetty)
  (:require  [poolr.api.games :as games]))

(defn unauthorized
  "Send unauthorized to client"
  [req]
  {:status 401})


(defn wrap-security
  "Security wrapper for the modification actions"
  [app]
  (fn [req]
    (if (= (:request-method req) :get)
      (app req)
      (unauthorized req))))

;; Routes definition
(def routes
  (app
   (wrap-params)
   (wrap-security)
   ["games"]  {:get games/list-games :post games/new-game}
   ["games" id] {:get (delegate games/get-game id)
                 :put (delegate games/update-game id)
                 :delete (delegate games/delete-game id)}))


;;; start function for starting jetty
(defn start [port]
  (run-jetty #'routes {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))
