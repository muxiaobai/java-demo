package io.github.muxiaobai.tool.guava.date;

import cn.hutool.core.date.DateUtil;

import java.util.Date;


public class DateOffsetTest {

    public static void main(String[] args) {
        System.out.println(DateUtil.offsetDay(new Date(),-30));
    }


}
