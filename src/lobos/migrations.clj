(ns lobos.migrations
  "lobos migrations"
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:use (lobos [migration :only [defmigration]]
               core
               schema
               config
               helpers)))

(defmigration add-users-table
  (up [] (create
          (tbl :users
               (varchar :name 100 :unique)
               (varchar :email 1024 :unique)
               (varchar :twitter_id 140)
               (check :name (> (length :name) 1)))))
  (down [] (drop (table :users))))
