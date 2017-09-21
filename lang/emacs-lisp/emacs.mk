EMACS ?= emacs
EMACSFLAGS =

COMPILE.el = $(EMACS) -batch $(EMACSFLAGS) -f batch-byte-compile

%.elc: %.el
	$(COMPILE.el) $<
