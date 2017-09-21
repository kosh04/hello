include emacs.mk

TARGET := hello.elc

default: info run

info:
	$(EMACS) --version

run: $(TARGET)
#	$(EMACS) -batch -l $(TARGET)
	$(EMACS) --script $(TARGET)

clean:
	$(RM) $(TARGET)

.PHONY: run clean
