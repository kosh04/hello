BAT    = $(if $(findstring $(OS),Windows_NT),.bat)
PERL6 ?= perl6$(BAT)

default: info run

info:
	$(PERL6) --version

run:
	$(PERL6) hello.p6

clean:
	# NOTHING_TO_DO

.PHONY: info run clean
