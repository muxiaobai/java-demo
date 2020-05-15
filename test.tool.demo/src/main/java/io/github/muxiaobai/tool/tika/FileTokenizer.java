package io.github.muxiaobai.tool.tika;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class FileTokenizer {
    public static void main(String[] args)  throws Exception {
        String fileName= "2016中国人工智能大会在京召开.docx";
        parserFile(new File(fileName));
    }

    public static Map extractFile(String filePath) throws Exception {
        Map map = new HashMap();
        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            System.out.println("文件夹路径错误!");
        }
        File[] allFiles = fileDir.listFiles();

        for (File f : allFiles) {
            map.put(f.getName(),parserFile(f));
        }
        return map;
    }
    public static String parserFile(File file) throws Exception {
        InputStream inputStream = new FileInputStream(file);
        String fileContent =parserInputStream(inputStream);
        ///测试使用
//        Tika tika = new Tika();
//        String fileType = tika.detect(file);
//        System.out.println(tika.parseToString(file));
        System.out.println("name:"+file.getName()+",fileContent:"+fileContent);
        return fileContent;
    }
    public static String parserInputStream(InputStream inputStream) throws Exception {
        // 接收文档内容
        BodyContentHandler handler = new BodyContentHandler();
        // 自动解析器接口
        Parser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(inputStream, handler, metadata, context);
        String fileContent = handler.toString();
        String[] metadataNames = metadata.names();
        for(String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name) );
        }
        return fileContent;
    }
}
