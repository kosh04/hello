_BAT = $(if $(findstring $(OS),Windows_NT),.bat)
LEIN ?= lein$(_BAT)

VERSION = 1.0-SNAPSHOT
TARGET  = target/hello-$(VERSION)-standalone.jar

.PHONY: default info run test clean version build

default: info test run

run:
	$(LEIN) run

test:
	$(LEIN) test

version info:
	$(LEIN) version

clean:
	$(LEIN) clean

build: $(TARGET)

$(TARGET):
	$(LEIN) uberjar
