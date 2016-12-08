(defproject clojure-lunch-and-learn "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [rhizome "0.2.7"]
                 [com.datomic/datomic-free "0.9.5544"]
                 [com.datomic/clj-client "0.8.606"]
                 [camel-snake-kebab "0.4.0"]]
  :main ^:skip-aot clojure-lunch-and-learn.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
