(ns poolr.test.migrations
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:use clojure.test
        lobos.connectivity
        lobos.core
        lobos.migrations))

(deftest test-db-spec
  (assert (not (nil? lobos.config/db))))

(deftest test-all-migrations)
