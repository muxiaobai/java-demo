//package io.github.muxiaobai.tool.javacv;
//
//import org.bytedeco.javacpp.opencv_core;
//import org.bytedeco.javacpp.opencv_core.Mat;
//import org.bytedeco.javacpp.opencv_core.Rect;
//
//import java.net.URL;
//
//import static org.bytedeco.javacpp.opencv_core.flip;
//import static org.bytedeco.javacpp.opencv_highgui.*;
//import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
//
//
//public class javacpp {
//    public static void main(String[] args) {
//        URL url =ClassLoader.getSystemResource("files");
//        String path = url.getPath();
//        String filename = path.replaceFirst("/", "")+ "/example1.png";
//        recover(filename);
//        logo(path.replaceFirst("/", ""));
//    }
//
//    static  void  recover(String filename){
//        Mat image = imread(filename);
//        //判断图像是否有效
//        if(image.empty()) {
//            System.out.println("未创建对象！");
//        }
//        //在一窗口显示结果
//        namedWindow("输入图片显示窗口");//定义窗口
//        imshow("输入图片显示窗口",image);//显示窗口
//
//        opencv_core.Mat result=new opencv_core.Mat();//创建另一个空图像
//        flip(image,result,0);//正数表示是水平,0表示垂直,负数表示水平和垂直
//        //在另一窗口显示结果
//        namedWindow("输出图片显示窗口");//定义窗口
//        imshow("输出图片显示窗口",result);//显示窗口
//        //imwrite("./Resources/output.jpg",result);//保存结果，一般支持格式bmp、png、tiff、jpg
//        waitKey(0);//因为他是控制台窗口，会在mian函数结束时关闭;0表示永远的等待按键,正数表示等待指定的毫秒数
//    }
//    static  void  logo(String path) {
//        //Mat类是用来存放图像（以及其他矩阵数据）的数据结构
//        Mat image = imread(path+"/example1.png");
//        Mat logo = imread(path+"/example7.png");
//        //ROI:兴趣区域
//        Mat imageROI = new Mat(image, new Rect(0, 0, logo.cols(), logo.rows()));
//        //第一个参数表示插入目标图片，Rect构造函数的前两个参数插入图片的左上角位置，后两个参数表示宽度和高度
//        logo.copyTo(imageROI);//插入标志
//        namedWindow("演示窗口");//定义窗口
//        imshow("演示窗口", image);//显示窗口
//        waitKey(0);//因为他是控制台窗口，会在mian函数结束时关闭;0表示永远的等待按键,正数表示等待指定的毫秒数
//    }
//}
