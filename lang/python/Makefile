PYTHON ?= python
PY_CACHE_TAG := $(shell $(PYTHON) -c "import sys; print(sys.implementation.cache_tag)")

default: info run

info:
	$(PYTHON) --version

run:
	$(PYTHON) hello.py

__pycache__/%.$(PY_CACHE_TAG).pyc: %.py
	$(PYTHON) -m py_compile $^

compile:
	$(PYTHON) -m compileall .

clean:
	# NOTHING_TO_DO

.PHONY: default info run compile clean
