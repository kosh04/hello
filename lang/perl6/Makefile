PERL6 ?= perl6$(if $(findstring $(OS),Windows_NT),.bat)

default: info run

info:
	$(PERL6) --version

run:
	$(PERL6) hello.p6

clean:
	# NOTHING_TO_DO

.PHONY: info run clean
