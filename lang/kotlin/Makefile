ifeq ($(OS),Windows_NT)
	KOTLIN_HOME ?= /c/opt/kotlinc
	PATH := $(PATH):$(KOTLIN_HOME)/bin:/c/opt/Gow/bin
endif

.PHONY: default info run run_standalone clean

default: info run_standalone

info:
	kotlin -version

run_standalone: hello-standalone.jar
	java -jar $^

run: hello.jar
	kotlin -classpath $^ HelloKt
#	kotlin -classpath . HelloKt

clean:
	$(RM) *.jar *.class

%-standalone.jar: %.kt
	kotlinc $< -include-runtime -d $@

%.jar: %.kt
	kotlinc $< -d $@

%.class: %.kt
	kotlinc $<
