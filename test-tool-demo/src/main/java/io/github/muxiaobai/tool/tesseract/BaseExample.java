package io.github.muxiaobai.tool.tesseract;
import org.bytedeco.javacpp.*;
import org.bytedeco.leptonica.*;
import org.bytedeco.tesseract.*;
import static org.bytedeco.leptonica.global.lept.*;
import static org.bytedeco.tesseract.global.tesseract.*;

/**
 * 图片内容识别ocr
 */
public class BaseExample {

    public static void main(String[] args) {
//        String result = ocr("chi_sim","E:\\tools\\opencv\\traineddata\\","C:\\Users\\Administrator\\Desktop\\1.png");
//   https://github.com/tesseract-ocr/tessdata/blob/master/eng.traineddata
//   https://github.com/bytedeco/javacpp-presets/tree/master/tesseract
        String result = ocr("chi_sim","E:\\tools\\opencv\\traineddata\\","C:\\Users\\Administrator\\Desktop" +
                "\\37cc4910637262d83807a5809b398505.png");
        System.out.println(result);
    }
    public static  String ocr(String language,String dataPath, String imageUrl) {
        BytePointer outText;
        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(dataPath, language) != 0) {
            System.err.println("Could not initialize tesseract.");
            return null;
        }
        // Open input image with leptonica library
        PIX image = pixRead(imageUrl);
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        try {
            return outText.getString();
        }finally{
            // Destroy used object and release memory
            api.End();
            outText.deallocate();
            pixDestroy(image);
        }
    }
}
