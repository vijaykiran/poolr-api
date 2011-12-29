(ns poolr.test.fixtures
  "Fixtures for tests"
  (:use korma.db
        korma.core
        clj-yaml.core))

(defdb test-db (postgres {:db "poolr-test"
                             :user "poolr-test"
                             :password "poolr-test"}))

(defn load-fixtures
  "Loads fixture data from yml to test database"
  []
  (let [data (parse-string (slurp "test/resources/test-data.yml"))]))
