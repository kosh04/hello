_EXT    = $(if $(findstring $(OS),Windows_NT),.exe)
TARGET  = hello$(_EXT)
VERSION = 0.1
SOURCES = main.go cli.go
LDFLAGS = -ldflags "-X main.Version=$(VERSION)"

.PHONY: default run build test

default: info run

$(TARGET): $(SOURCES)
	go build $(LDFLAGS) -o $@ $^

build: $(TARGET)

info:
	go version

run: $(TARGET)
	# go run $(SOURCES)
	./$(TARGET)

test:
	go test -v ./...

clean:
	go clean
