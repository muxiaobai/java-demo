package io.github.muxiaobai.common.ConvertUtil;

import java.util.Map;
import java.util.Properties;


public class SysProp {
    public static void main(String[] args) {
        Map env = System.getenv();
        env.entrySet().stream().forEach(x -> {
            System.out.println("env : " + x.toString());
        });
        Properties properties = System.getProperties();
        properties.keySet().stream().forEach(x -> {
            System.out.println("prop key:" + x.toString() + ",value:" + properties.getProperty(x.toString()));
        });
    }
}
