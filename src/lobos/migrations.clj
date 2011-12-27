(ns lobos.migrations
  "lobos migrations"
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:use (lobos [migration :only [defmigration]]
               core
               schema
               config
               helpers)))

(defmigration add-players-table
  (up [] (create
          (tbl :players
               (varchar :name 100 :unique)
               (varchar :email 1024 :unique)
               (varchar :twitter 140 :unique)
               (check :name (> (length :name) 1)))))
  (down [] (drop (table :players))))

(defmigration add-games-table
  (up [] (create
          (tbl :games
               (time :game_date)
               (integer :winner_score :not-null)
               (integer :loser_score :not-null)
               (integer :winner [:refer :players :id] :not-null)
               (integer :loser [:refer :players :id] :not-null))))
  (down [] (drop (table :games))))

(defmigration add-history-table
  (up [] (create
          (tbl :ranks
               (integer :player_id [:refer :players :id] :not-null)
               (integer :rank)
               (integer :game_id [:refer :games :id] :not-null))))
  (down [] (drop (table :ranks))))
