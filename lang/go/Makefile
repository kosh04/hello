_EXT    = $(if $(findstring $(OS),Windows_NT),.exe)
TARGET  = hello$(_EXT)
VERSION = 0.1
SOURCES = $(shell go list -f '{{ join .GoFiles "\n"}}')
LDFLAGS = -ldflags "-X main.Version=$(VERSION)"

.PHONY: default run build test debug clean

default: info run

$(TARGET): $(SOURCES)
	go build $(LDFLAGS) -o $@ $^

build: $(TARGET)

info:
	go version

run: $(TARGET)
#	go run $(SOURCES)
	./$(TARGET)

test:
	go test -v ./...

debug: LDFLAGS += -gcflags=all="-N -l"
debug: $(TARGET)
	gdb ./$(TARGET)

clean:
	go clean
	$(RM) $(TARGET)
