package io.github.muxiaobai.tool.javacv;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import java.net.URL;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class javacvOpencv {
    public static void main(String[] args) {
        URL url =ClassLoader.getSystemResource("files");
        String path = url.getPath();
        String filename = path.replaceFirst("/", "")+ "/example1.png";
        getFloatArray(filename);
    }
    static  void  getFloatArray(String filename){
        Mat image = imread(filename);
        //判断图像是否有效
        if(image.empty()) {
            System.out.println("未创建对象！");
        }
        GaussianBlur(image, image, new Size(3, 3), 0);
        imwrite(filename, image);
    }

}
