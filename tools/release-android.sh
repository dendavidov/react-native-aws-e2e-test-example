#!/usr/bin/env bash

# Path to key
KEY_PATH=/home/denis/Android/test2.jks

# Path to unsigned apk
APK=./android/app/build/outputs/apk/app-release-unsigned.apk

yarn android:build

rm -rf ./build
mkdir ./build

${ANDROID_HOME}/build-tools/27.0.3/zipalign -v -p 4 ${APK} ./build/homeapp.android.aligned.apk && \
 rm -f ./build/homeapp.android.release.apk && \
${ANDROID_HOME}/build-tools/27.0.3/apksigner sign --ks ${KEY_PATH} --out ./build/homeapp.android.release.apk ./build/homeapp.android.aligned.apk
