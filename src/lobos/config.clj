(ns lobos.config
  (:use lobos.connectivity)
  (import java.net.URI))

(defn url-to-db-spec
  "Creates a dbspec map from URI String"
  [db-url]
  (let [uri (URI. db-url)
        port (.getPort uri)
        host (.getHost uri)
        path (.getPath uri)
        [user password] (clojure.string/split (.getUserInfo uri) #":") ]
    {:classname "org.postgresql.Driver"
     :subprotocol (.getScheme uri)
     :subname (str "//" host
                   (if (= -1 port) "" (str ":" port))
                   path)
     :user user
     :password password}))

(def db (url-to-db-spec (System/getenv "DATABASE_URL")))

