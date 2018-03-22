#!/usr/bin/env bash

cd ./android
./gradlew assembleDebugAndroidTest
cd ../

## Path to key
KEY_PATH=/home/denis/Android/test2.jks
#
## Path to unsigned apk
APK=./android/app/build/outputs/apk/app-debug-androidTest.apk
#
rm -f ./build/app-debug.aligned.apk
rm -f ./build/app-debug-androidTest.apk
#
#
${ANDROID_HOME}/build-tools/27.0.3/zipalign -v -p 4 ${APK} ./build/app-debug.aligned.apk

${ANDROID_HOME}/build-tools/27.0.3/apksigner sign --ks ${KEY_PATH} --out ./build/signed_app-debug-androidTest.apk ./build/app-debug.aligned.apk


${ANDROID_HOME}/build-tools/27.0.3/apksigner verify ./build/signed_app-debug-androidTest.apk


#appcenter test run espresso --app "dendavidov/nt" --devices dcfab3bd \
# --app-path ./build/homeapp.android.release.apk  --test-series "master" --locale "en_US" --build-dir ./build


appcenter test run espresso --app "dendavidov/nt" --devices 545534bd --app-path ./build/homeapp.android.release.apk  --test-series "test" --locale "en_US" --build-dir ./build
