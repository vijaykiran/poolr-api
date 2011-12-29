(ns poolr.api.model
  "Poolr models and database access functions and vars"
  (:use korma.db
        korma.core)
  (:require [poolr.utils :as utils]))


(defdb prod-db (utils/url-to-db-spec (System/getenv "DATABASE_URL")))

;;; Entity definitions
(defentity players)
(defentity games)
(defentity ranks)
