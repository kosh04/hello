(ns hello.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.string :as string])
  (:gen-class main true))

(def program
  ;; NOTE: This code is only available within Leiningen
  ;; (System/getProperty "hello.version") ;;=> "1.0"
  {:name "Hello"
   :version "1.0"})

(def greeting
  {:modern      "Hello, world!"
   :traditional "hello, world"})

(def cli-options
  [["-g" "--greeting TEXT" "Greering message"]
   ["-t" "--traditional" "Traditional greeting message"]
   ["-v" "--version"]
   ["-h" "--help"]])

(defn- usage [options-summary]
  (letfn [(mkdoc [& lines]
            (string/join \newline lines))]
    (mkdoc
     (format "Usage: %s [options]" (:name program))
     ""
     "Options:"
     options-summary)))

(defn hello-world [text])

(defn -main [& args]
  (let [{:keys [options arguments summary errors]}
        (parse-opts args cli-options)]
    (cond
      (:version options) (println program)
      (:help options) (println (usage summary))
      errors (binding [*out* *err*]
               (println (string/join \newline errors)))
      :else (println (or (:greeting options)
                         (and (:traditional options)
                              (:traditional greeting))
                         (:modern greeting))))))
