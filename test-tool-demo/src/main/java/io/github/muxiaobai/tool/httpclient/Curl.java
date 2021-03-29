package io.github.muxiaobai.tool.httpclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Zhang Pengfei
 * @version V1.0
 * @PROJECT_NAME java-demo
 * @Package io.github.muxiaobai.java.httpclient
 * @date 2021/3/26/026 15:11
 */
public class Curl {

    public static void main(String[] args) {
        String[] cmds = {"curl", "-XGET", " -u 'elastic:elasticsearch_2017@*))'", "-H 'Content-Type:application/json'",
                " -d '{\"from\":0,\"size\":20,\"timeout\":\"60s\"," +
                        "\"query\":{\"bool\":{\"must\":[{\"multi_match\":{\"query\":\"x x\"," +
                        "\"fields\":[\"title^10.0\",\"title.hanLP^10.0\",\"title.ik^10.0\"],\"boost\":1}}]}}}'",
                "http://192.168.160.23:9200/xxx/_search"};
        System.out.println(execCurl(cmds));
    }

    static String execCurl(String[] cmds) {
//        System.out.println(StringUtils.join(cmds," "));
        System.out.println(Arrays.toString(cmds));
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;
    }
}
