(ns clJansi.core
	(:use [clojure.contrib.import-static])
	(:import [org.fusesource.jansi AnsiConsole AnsiRenderWriter AnsiRenderer])
	(:gen-class))

(import-static org.fusesource.jansi.AnsiConsole systemInstall)
(import-static org.fusesource.jansi.AnsiRenderer render)
(def writer (AnsiRenderWriter. *out* true))

(defn print-ansi
	[text]
	(.write writer (render text)))
	;(.println org.fusesource.jansi.AnsiConsole/out (render text)))

(defn -main [& args]
	(systemInstall)
	(print-ansi "@|red Hello|@ @|green World|@"))
	;(println (.. org.fusesource.jansi.Ansi (ansi) (render "@|red Hello|@ @|green World|@") (toString))))
