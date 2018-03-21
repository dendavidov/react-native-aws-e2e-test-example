#!/usr/bin/env bash

. ./venv/bin/activate
LOCATION='local'
py.test --collect-only tests/

pip freeze > requirements.txt

pip wheel --wheel-dir wheelhouse -r requirements.txt

cd tests
find . -name '__pycache__' -type d -exec rm -r {} +
find . -name '*.pyc' -exec rm -f {} +
find . -name '*.pyo' -exec rm -f {} +
find . -name '*~' -exec rm -f {} +
cd ..

zip -r build/test_bundle.zip tests/ wheelhouse/ requirements.txt

deactivate
