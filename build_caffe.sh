#!/usr/bin/env bash
set -e

WD=$(readlink -f "$(dirname "$0")")

export NDK_ROOT=${WD}/android-ndk-r15c

if [ -z "$NDK_ROOT" ] && [ "$#" -eq 0 ]; then
    echo "Either NDK_ROOT should be set or provided as argument"
    echo "e.g., 'export NDK_ROOT=/path/to/ndk' or"
    echo "      '${0} /path/to/ndk'"
    exit 1
else
    NDK_ROOT=$(readlink -f "${1:-${NDK_ROOT}}")
    export NDK_ROOT="${NDK_ROOT}"
fi

cd "${WD}"

export ANDROID_ABI="${ANDROID_ABI:-"arm64-v8a"}"
export N_JOBS=${N_JOBS:-1}

./scripts/build_caffe_on_acl.sh

echo "DONE!!"
