(ns lobos.config
  "lobos configuration"
  (:require [poolr.utils :as pu]))


;;; Shared database url on heroku is available via the env config variable "DATABASE_URL"
(def db (pu/url-to-db-spec (System/getenv "DATABASE_URL")))
