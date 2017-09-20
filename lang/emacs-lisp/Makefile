include emacs.mk

TARGET := hello.elc

default: run

run: $(TARGET)
#	$(EMACS) -batch -l $(TARGET)
	$(EMACS) --script $(TARGET)

clean:
	$(RM) $(TARGET)

.PHONY: run clean
