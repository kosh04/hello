default: info test run

info:
	mvn --version

compile:
	mvn compile

run exec: compile
	mvn exec:java -Dexec.args=""

test:
	mvn test

package:
	mvn package

clean:
	mvn clean

.PHONY: default compile run exec test clean
