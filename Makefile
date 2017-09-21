LANGUAGES := $(wildcard lang/*/.)

default info clean: $(LANGUAGES)

$(LANGUAGES):
	$(MAKE) -C $(@) $(MAKECMDGOALS)

.PHONY: default info clean $(LANGUAGES)
