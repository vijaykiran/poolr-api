(ns poolr.api.core
  (:use
   net.cgrand.moustache
   ring.middleware.params
   ring.adapter.jetty)
  (:require  [poolr.api.games :as games]))



;; Routes definition
(def routes
  (app
   (wrap-params)
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
