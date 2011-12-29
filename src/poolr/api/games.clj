(ns poolr.api.games
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
