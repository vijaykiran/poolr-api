(defproject poolr-api "0.0.1-SNAPSHOT"
  :description "Lunatech Pool Ladder API"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [ring "1.0.0"]
                 [net.cgrand/moustache "1.1.0"]
                 [lobos "1.0.0-SNAPSHOT"]
                 [korma "0.2.1"]
                 [postgresql "9.1-901.jdbc4"]
                 [clj-yaml "0.3.1"]]
  :dev-dependencies [[lein-marginalia "0.7.0-SNAPSHOT"]])
