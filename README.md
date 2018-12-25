CaffeOnACL-Android
===============
## Goal
Porting [CaffeOnACL] to RK3399 Android platform

### Support
The release is based on [Rockchip RK3399](http://www.rock-chips.com/plus/3399.html) Platform
* ACL/NEON
* ACL/GPU(OpenCL)
* OpenBLAS
* Mixed Mode

## Build
Tested with Android [NDK] r15c and cmake 3.5.1 on Ubuntu 14.04

```shell
# Install some dependencies
sudo apt-get install python-dev python-pip cmake
sudo pip install pyyaml six

cd CaffeOnACL-Android

# Build Caffe
./build_caffe.sh

# Download network
./model_download.sh

# Prepare model data for RK3399 device
./model_prepare.sh

# Update binary data for RK3399 device
./binary_update.sh

# Running SqueezeNet network (default is AlexNet, support AlexNet, GoogLeNet, SqueezeNet, MobileNet)
./model_runner.py SqueezeNet

```

## Prebuilts
Library|Version
:---:|:---:
Arm Compute Library |v17.10
OpenBLAS|v0.2.20
Boost|v1.65
glog|v0.3.3
gflags|v2.2.0
protobuf|v3.1.0
lmdb|v0.9.21
OpenCV|v3.3.0
