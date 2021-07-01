//package io.github.muxiaobai.tool.javacv;
//
//import io.github.muxiaobai.common.FilePathUtil.SystemPathUtil;
//import org.bytedeco.ffmpeg.global.avcodec;
//import org.bytedeco.javacpp.Loader;
//import org.bytedeco.javacpp.opencv_objdetect;
//import org.bytedeco.javacv.*;
//import org.junit.Test;
//import org.opencv.core.*;
//import org.opencv.features2d.DescriptorExtractor;
//import org.opencv.features2d.DescriptorMatcher;
//import org.opencv.features2d.FeatureDetector;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//
//import javax.swing.*;
//import java.net.MalformedURLException;
//import java.util.concurrent.TimeUnit;
//
//
//public class JavaCVCamera {
//
//    @Test
//    public void testCamera() throws InterruptedException, FrameGrabber.Exception {
//        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
//        grabber.start();   //开始获取摄像头数据
//        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
//        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        canvas.setAlwaysOnTop(true);
//        while (true) {
//            if (!canvas.isDisplayable()) {//窗口是否关闭
//                grabber.stop();//停止抓取
//                System.exit(-1);//退出
//            }
//
//            Frame frame = grabber.grab();
//
//            canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
//            Thread.sleep(50);//50毫秒刷新一次图像
//        }
//    }
//
//    @Test
//    public void testCamera1() throws FrameGrabber.Exception, InterruptedException {
//        VideoInputFrameGrabber grabber = VideoInputFrameGrabber.createDefault(0);
//        grabber.start();
//        CanvasFrame canvasFrame = new CanvasFrame("摄像头");
//        canvasFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        canvasFrame.setAlwaysOnTop(true);
//        while (true) {
//            if (!canvasFrame.isDisplayable()) {
//                grabber.stop();
//                System.exit(-1);
//            }
//            Frame frame = grabber.grab();
//            canvasFrame.showImage(frame);
//            Thread.sleep(30);
//        }
//    }
//
//
//    private void showFrames(String winTitle, FrameGrabber grabber) throws FrameGrabber.Exception, InterruptedException {
//        CanvasFrame canvas = new CanvasFrame(winTitle,1);//新建一个窗口
//        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        canvas.setAlwaysOnTop(true);
//        while (true) {
//            if (!canvas.isVisible()) {
//                break;
//            }
//            Frame frame = grabber.grab();
//            canvas.showImage(frame);
//            Thread.sleep(50);//50毫秒刷新一次图像
//        }
//    }
//
////    private void showFramesWithFace(String winTitle, FrameGrabber grabber) throws FrameGrabber.Exception, InterruptedException {
////        OpenCVFrameConverter.ToMat convertToMat = new OpenCVFrameConverter.ToMat();
////        File fileAbsolutePath = new File(ClassLoader.getSystemClassLoader().getResource("data/lbpcascade_frontalface_improved.xml").getFile());
////        //opencv_objdetect.CvHaarClassifierCascade face_cascade=opencv_objdetect.cvLoadHaarClassifierCascade(fileAbsolutePath.getAbsolutePath(),new opencv_core.CvSize(0,0));
////        opencv_objdetect.CascadeClassifier face_cascade = new opencv_objdetect.CascadeClassifier(fileAbsolutePath.getAbsolutePath());
////        opencv_core.RectVector faces = new opencv_core.RectVector();
////        CanvasFrame canvas = new CanvasFrame(winTitle,1);//新建一个窗口
////        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
////        canvas.setAlwaysOnTop(true);
////        while (true) {
////            if (!canvas.isVisible()) {
////                break;
////            }
////            Frame frame = grabber.grab();
////            Mat mat = convertToMat.convert(frame);
////            if (mat.empty())
////                continue;
////            Mat videoMatGray = new Mat();
////            opencv_imgproc.cvtColor(mat, videoMatGray, COLOR_BGRA2GRAY);
////            opencv_imgproc.equalizeHist(videoMatGray, videoMatGray);
////            //int[] rejectLevels = new int[0];
////            //double[] levelWeights = new double[0];
////            face_cascade.detectMultiScale(videoMatGray, faces);
////            for (int i = 0; i < faces.size(); i++) {
////                opencv_core.Rect face = faces.get(i);
////                opencv_imgproc.rectangle(mat, face, opencv_core.Scalar.RED, 4, 8, 0);
////            }
////
////            //opencv_highgui.imshow(winTitle, mat);
////            //opencv_highgui.waitKey(30);
////            canvas.showImage(convertToMat.convert(mat));
////            Thread.sleep(30);//50毫秒刷新一次图像
////        }
////    }
//
//    @Test
//    public void testCamera3() throws InterruptedException, FrameGrabber.Exception {
//        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
//        grabber.setImageWidth(1280);
//        grabber.setImageHeight(720);
//        grabber.start();   //开始获取摄像头数据
//        showFrames("Camera", grabber);
//        grabber.stop();
//        grabber.close();
//    }
//
//    @Test
//    public void testCamera4() throws FrameGrabber.Exception, InterruptedException {
//        VideoInputFrameGrabber grabber = new VideoInputFrameGrabber(0);
//        grabber.start();   //开始获取摄像头数据
//        showFrames("Camera", grabber);
//        grabber.stop();
//        grabber.close();
//    }
//
//    @Test
//    public void testCamera2() throws FrameGrabber.Exception, InterruptedException, MalformedURLException {
//        IPCameraFrameGrabber grabber = new IPCameraFrameGrabber("http://admin:12345@192.0.0.64:554/MPEG-4/ch1/main/av_stream", 30, 30, TimeUnit.SECONDS);
//        grabber.start();
//        showFrames("IPCamera", grabber);
//        grabber.stop();
//        grabber.close();
//    }
//
//    @Test
//    public void testVideo() throws FrameGrabber.Exception, InterruptedException, MalformedURLException {
//        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault("C:\\Users\\Administrator\\Documents\\Apowersoft\\ApowerREC\\20200520_150117.mp4");
////        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault("rtmp://127.0.0.1:12580/live/app"); //这里也可以是本地文件，也可以网络文件。如：rtmp://127.0.0.1:12580/live/app
//        grabber.setImageWidth(1366);
//        grabber.setImageHeight(768);
//        grabber.start();
//        showFrames("Video", grabber);
//        grabber.stop();
//        grabber.close();
//    }
//
//    @Test
//    public void testFaceRecognize() throws FrameGrabber.Exception, InterruptedException, MalformedURLException, FrameRecorder.Exception {
//        OpenCVFrameGrabber grabber = OpenCVFrameGrabber.createDefault(0);
//        grabber.start();
////        showFramesWithFace("Video", grabber);
//        grabber.stop();
//        grabber.close();
//    }
//    @Test
//    public void imgMatching2() throws Exception {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        String path = SystemPathUtil.getResourceStartPath("files");
//        Mat src_base = Imgcodecs.imread(path+"\\example1.png");
//        Mat src_test = Imgcodecs.imread(path+"\\example2.png");
//        Mat gray_base = new Mat();
//        Mat gray_test = new Mat();
//        // 转换为灰度
//        Imgproc.cvtColor(src_base, gray_base, Imgproc.COLOR_RGB2GRAY);
//        Imgproc.cvtColor(src_test, gray_test, Imgproc.COLOR_RGB2GRAY);
//        // 初始化ORB检测描述子
//        FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.ORB);
//        //特别提示下这里opencv暂时不支持SIFT、SURF检测方法，这个好像是opencv(windows) java版的一个bug,本人在这里被坑了好久。
//        DescriptorExtractor descriptorExtractor = DescriptorExtractor.create(DescriptorExtractor.ORB);
//        // 关键点及特征描述矩阵声明
//        MatOfKeyPoint keyPoint1 = new MatOfKeyPoint(), keyPoint2 = new MatOfKeyPoint();
//        Mat descriptorMat1 = new Mat(), descriptorMat2 = new Mat();
//        // 计算ORB特征关键点
//        featureDetector.detect(gray_base, keyPoint1);
//        featureDetector.detect(gray_test, keyPoint2);
//        // 计算ORB特征描述矩阵
//        descriptorExtractor.compute(gray_base, keyPoint1, descriptorMat1);
//        descriptorExtractor.compute(gray_test, keyPoint2, descriptorMat2);
//        float result = 0;
//        // 特征点匹配
//        System.out.println("test5：" + keyPoint1.size());
//        System.out.println("test3：" + keyPoint2.size());
//        if (!keyPoint1.size().empty() && !keyPoint2.size().empty()) {
//            // FlannBasedMatcher matcher = new FlannBasedMatcher();
//            DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_L1);
//            MatOfDMatch matches = new MatOfDMatch();
//            matcher.match(descriptorMat1, descriptorMat2, matches);
//            // 最优匹配判断
//            double minDist = 100;
//            DMatch[] dMatchs = matches.toArray();
//            int num = 0;
//            for (int i = 0; i < dMatchs.length; i++) {
//                if (dMatchs[i].distance <= 2 * minDist) {
//                    result += dMatchs[i].distance * dMatchs[i].distance;
//                    num++;
//                }
//            }
//            // 匹配度计算
//            result /= num;
//        }
//        System.out.println(result);
//    }
//    public static void main(String[] args) throws FrameGrabber.Exception, FrameRecorder.Exception, InterruptedException {
//        // Preload the opencv_objdetect module to work around a known bug.
//        String str = Loader.load(opencv_objdetect.class);
//        System.out.println(str);
//
//        FrameGrabber grabber = FrameGrabber.createDefault(0);
//        grabber.start();
//        Frame grabbedImage = grabber.grab();//抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
//        int width = grabbedImage.imageWidth;
//        int height = grabbedImage.imageHeight;
//
//        String outputFile = "d:\\record.mp4";
//        //String outputFile = "rtmp://127.0.0.1:1935/rtmplive/picamera";
//        FrameRecorder recorder = FrameRecorder.createDefault(outputFile, width, height); //org.bytedeco.javacv.FFmpegFrameRecorder
//        System.out.println(recorder.getClass().getName());//org.bytedeco.javacv.FFmpegFrameRecorder
//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);// avcodec.AV_CODEC_ID_H264，编码
//        recorder.setFormat("flv");//封装格式，如果是推送到rtmp就必须是flv封装格式
//        recorder.setFrameRate(25);
//        recorder.start();//开启录制器
//        long startTime = 0;
//        long videoTS;
//        CanvasFrame frame = new CanvasFrame("camera", CanvasFrame.getDefaultGamma() / grabber.getGamma()); //2.2/2.2=1
//        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setAlwaysOnTop(true);
//        Frame rotatedFrame;
//        while (frame.isVisible() && (rotatedFrame = grabber.grab()) != null) {
//            frame.showImage(rotatedFrame);
//            if (startTime == 0) {
//                startTime = System.currentTimeMillis();
//            }
//            videoTS = (System.currentTimeMillis() - startTime) * 1000;//这里要注意，注意位
//            recorder.setTimestamp(videoTS);
//            recorder.record(rotatedFrame);
//            Thread.sleep(40);
//        }
//        recorder.stop();
//        recorder.release();
//        frame.dispose();
//        grabber.stop();
//        grabber.close();
//    }
//}