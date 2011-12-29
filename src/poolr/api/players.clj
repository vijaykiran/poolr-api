(ns poolr.api.players
  "Players handler functions")

(defn list-players [req]
  (println "list players"))

(defn new-player
  "Creates new player"
  [req]
  (println "new-player"))

(defn get-player
  "Get the player details"
  [req id]
  (println (str "get player details" id)))

(defn update-player
  "Update the player with the details"
  [req id]
  (println (str "Updating player details" id)))

(defn delete-player
  "Deletes a player"
  [req id]
  (println (str "deleting player" id)))
