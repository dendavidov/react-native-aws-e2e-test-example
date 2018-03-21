#!/usr/bin/env bash
appcenter test run appium --app "dendavidov/nt" --devices 3e2ea094 --app-path build/homeapp.android.release.apk  \
--test-series "master" --locale "en_US" --build-dir target/upload
