.PHONY: all test clean build

clean:
	rm -rf target/*

repl:
	clojure -M:nrepl:dev:test

lint:
	clojure -M:dev -m clj-kondo.main --lint src/**

test:
	clojure -M:test -m kaocha.runner

build:
	rm sail.jar && clj -A:pack mach.pack.alpha.skinny --no-libs --project-path sail.jar 
