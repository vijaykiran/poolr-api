(ns poolr.test.fixtures
  "Fixtures for tests"
  (:use korma.db
        korma.core
        clj-yaml.core)
  (:require [poolr.api.db :as pdb]))

(defdb test-db (postgres {:db "poolr-test"
                             :user "poolr-test"
                             :password "poolr-test"}))

(defn load-fixtures
  "Loads fixture data from yml to test database"
  []
  (let [data (parse-string (slurp "test/resources/test-data.yml"))]
    (doseq [p (vals (:players data))]
     (insert pdb/players (values p)) )))
