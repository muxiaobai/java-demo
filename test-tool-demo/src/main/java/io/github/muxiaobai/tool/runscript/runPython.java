package io.github.muxiaobai.tool.runscript;

import io.github.muxiaobai.common.FilePathUtil.SystemPathUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class runPython {
    public static void main(String[] args) {
        RunPy("");
    }
    private static  void RunPy(String filePath){
        String fileName = "py.py";
        filePath = SystemPathUtil.getResourceStartPath("script") + "/" + fileName;
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(filePath);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
