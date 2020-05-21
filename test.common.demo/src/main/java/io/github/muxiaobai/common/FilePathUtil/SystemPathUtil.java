package io.github.muxiaobai.common.FilePathUtil;


import java.io.File;
import java.net.URL;

public class SystemPathUtil {
    public static String getResourcePath(String path){
        URL url =ClassLoader.getSystemResource(path);
        return url.getPath();
    }
    public static String getResourceStartPath(String path){
        URL url =ClassLoader.getSystemResource(path);
        return url.getPath().replaceFirst(File.separator,"");
    }
}
