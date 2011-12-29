(ns poolr.api.controller
  "Games handler functions")

(defn list-games [req]
  (println "list games"))

(defn new-game
  "Creates new game"
  [req]
  (println "new-game"))

(defn get-game
  "Get the game details"
  [req id]
  (println (str "get game details" id)))

(defn update-game
  "Update the game with the details"
  [req id]
  (println (str "Updating game details" id)))

(defn delete-game
  "Deletes a game"
  [req id]
  (println (str "deleting game" id)))

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
