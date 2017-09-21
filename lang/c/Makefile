CC ?= gcc
TARGET := hello

default: info run

info:
	$(CC) --version

run: $(TARGET)
	./$(TARGET)

clean:
	$(RM) $(TARGET)

.PHONY: info run clean
