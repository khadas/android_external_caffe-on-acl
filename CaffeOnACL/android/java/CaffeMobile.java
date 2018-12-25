
// Thanks to sh1r0, reference: https://github.com/sh1r0/caffe-android-demo

// TODO: add your package name

import java.nio.charset.StandardCharsets;

public class CaffeMobile {

    /* private class */
    private static byte[] stringToBytes(String s) {
        return s.getBytes(StandardCharsets.US_ASCII);
    }

    private native void setMeanWithMeanFile(String meanFile);

    private native void setMeanWithMeanValues(float[] meanValues);

    private native int[] predictImage(byte[] data, int width, int height, int k);

    private native float[] getConfidenceScore(byte[] data, int width, int height);

    private native float[][] extractFeatures(byte[] data, int width, int height, String blobNames);

    private native void native_setNumThreads(int numThreads);

    //private native void enableLog(boolean enabled);  // currently nonfunctional

    private native int native_loadModel(String modelPath, String weightsPath);  // required

    //private native void setScale(float scale);


    /* public class */

    /*
        * 设置CPU线程数，默认是2（RK3399中使用2线程，分别锁定在两个Cortex-A72性能最佳）
        * numThreads：线程数
        */
    public void setNumThreads(int numThreads) {
        native_setNumThreads(numThreads);
    }

    /*
        * 加载模型
        * modelPath：模型描述文件路径
        * weightsPath：模型权重数据路径
        * 成功则返回0
        */
    public int loadModel(String modelPath, String weightsPath) {
        return native_loadModel(modelPath, weightsPath);
    }

    /*
        * 图像预测
        * imgPath：输入图像文件路径
        * 返回所有类别预测的置信度
        */
    public float[] getConfidenceScore(String imgPath) {
        return getConfidenceScore(stringToBytes(imgPath), 0, 0);
    }

    /*
        * 图像预测
        * imgPath：输入图像文件路径
        * k：设置输出Top k排行的标签id
        * 返回Top k排行的标签id
        */
    public int[] predictImage(String imgPath, int k) {
        return predictImage(stringToBytes(imgPath), 0, 0, k);
    }

    /*
        * 图像预测
        * imgPath：输入图像文件路径
        * 返回Top排行的标签id
        */
    public int[] predictImage(String imgPath) {
        return predictImage(imgPath, 1);
    }

    /*
        * 提取中间层特征数据
        * imgPath：输入图像文件路径
        * blobNames：提取的中间层名称
        */
    public float[][] extractFeatures(String imgPath, String blobNames) {
        return extractFeatures(stringToBytes(imgPath), 0, 0, blobNames);
    }

    /*
        * 设置均值（内存方式加载）
        * meanValues：均值数据
        */
    public void setMean(float[] meanValues) {
        setMeanWithMeanValues(meanValues);
    }

    /*
        * 设置均值（文件方式加载）
        * meanFile：均值文件路径
        */
    public void setMean(String meanFile) {
        setMeanWithMeanFile(meanFile);
    }
}
