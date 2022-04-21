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
	if [ -f sail.jar ]; then rm sail.jar; fi && clj -M:pack mach.pack.alpha.skinny --no-libs --project-path sail.jar

deploy:
	CLOJARS_USERNAME="mikepjb" CLOJARS_PASSWORD=$$(pass show clojars-deploy) clojure -A:deploy

# build: test build-jar deploy
build: build-jar deploy

