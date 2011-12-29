(ns poolr.api.core
  (:use
   net.cgrand.moustache
   ring.middleware.params
   ring.adapter.jetty)
  (:require  [poolr.api.controller :as controller]))

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
   ["games"]  {:get controller/list-games
               :post controller/new-game}
   ["games" id] {:get (delegate controller/get-game id)
                 :put (delegate controller/update-game id)
                 :delete (delegate controller/delete-game id)}
   ["players"] {:get controller/list-players
                :post controller/new-player}
   ["players" id] {:get (delegate controller/get-player id)
                 :put (delegate controller/update-player id)
                 :delete (delegate controller/delete-player id)}))

;;; start function for starting jetty
(defn start [port]
  (run-jetty #'routes {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))
