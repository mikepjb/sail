.PHONY: all clean test build-jar

clean:
	rm -rf target/*

repl:
	clojure -M:nrepl:dev:test

lint:
	clojure -M:dev -m clj-kondo.main --lint src/**

test:
	clojure -M:test -m kaocha.runner

build-jar: 
	rm sail.jar && clj -M:pack mach.pack.alpha.skinny --no-libs --project-path sail.jar

build: test build-jar

