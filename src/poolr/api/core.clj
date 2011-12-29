(ns poolr.api.core
  (:use
   net.cgrand.moustache
   ring.middleware.params
   ring.adapter.jetty)
  (:require  [poolr.api.games :as games]
             [poolr.api.players :as players]))

;;; TODO Fix this to send response as JSON
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
   ;; TODO - should be refactored into a function generating the corresponding maps
   ["games"]  {:get games/list-games
               :post games/new-game}

   ["games" id] {:get (delegate games/get-game id)
                 :put (delegate games/update-game id)
                 :delete (delegate games/delete-game id)}
   ["players"] {:get players/list-players
                :post players/new-player}
   ["players" id] {:get (delegate players/get-player id)
                 :put (delegate players/update-player id)
                 :delete (delegate players/delete-player id)}))

;;; start function for starting jetty
(defn start [port]
  (run-jetty #'routes {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))
