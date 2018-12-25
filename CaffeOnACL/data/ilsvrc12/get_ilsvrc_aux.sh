#!/usr/bin/env sh
#
# N.B. This does not download the ilsvrcC12 data set, as it is gargantuan.
# This script downloads the imagenet example auxiliary files including:
# - the ilsvrc12 image mean, binaryproto
# - synset ids and words
# - Python pickle-format data of ImageNet graph structure and relative infogain
# - the training splits with labels

DIR="$( cd "$(dirname "$0")" ; pwd -P )"
cd "$DIR"

echo "Downloading..."

if [ -s caffe_ilsvrc12.tar.gz ]; then
  echo "caffe_ilsvrc12.tar.gz already exists, not getting it."
else
  wget -c http://dl.caffe.berkeleyvision.org/caffe_ilsvrc12.tar.gz -O /tmp/caffe_ilsvrc12.tar.gz.temp && mv /tmp/caffe_ilsvrc12.tar.gz.temp caffe_ilsvrc12.tar.gz
fi

echo "Unzipping..."

tar -xf caffe_ilsvrc12.tar.gz

echo "Done."
