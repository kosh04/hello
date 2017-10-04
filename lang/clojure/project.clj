(defproject hello "1.0-SNAPSHOT"
  :description "Simple Hello World Application"
  :url "http://github.com/kosh04/hello/lang/clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.4"]]
  ;;:profiles {:uberjar {:aot :all}}
  :aot [hello.core]
  :main hello.core)
