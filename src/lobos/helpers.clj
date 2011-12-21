(ns lobos.helpers
  "lobos helpers"
  (:refer-clojure :exclude [bigint boolean char double float time])
  (:use (lobos schema)))

(defn surrogate-key
  "Adds auto incremented integer primary key 'id' to the table"
  [table]
  (integer table :id :auto-inc :primary-key))

(defn timestamps
  "Add timestamps to a table"
  [table]
  (-> table
      (timestamp :updated_on)
      (timestamp :created_on (default (now)))))

(defn refer-to [table ptable]
  (let [cname (-> (->> ptable name butlast (apply str))
                  (str "_id")
                  keyword)]
    (integer table cname [:refer ptable :id :on-delete :set-null])))


(defmacro tbl
  "Macro to create table with timestamps and surrogate-key"
  [name & elements]
  `(-> (table ~name
              (surrogate-key)
              (timestamps))
              ~@elements))
