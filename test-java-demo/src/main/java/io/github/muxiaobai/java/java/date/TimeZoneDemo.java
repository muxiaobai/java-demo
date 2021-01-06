package io.github.muxiaobai.java.java.date;

import java.util.Date;
import java.util.TimeZone;

/**
 * 时间是相对于1970年1月1日的一个long毫秒数，而对应的时区才会是
 *
 * 系统的时间和时区
 * /etc/localtime
 * /etc/timezone   Asia/Shanghai
 *
 * date linux 时间展示的是   Thu Dec 31 21:36:05 CST 2020   这里的CST指的是 China Standard Time UT+8:00
 * date -R   RFC 2822 format    Thu, 31 Dec 2020 21:37:58 +0800  这里就会展示+800
 *
 * timedatectl
 *       Local time: Thu 2020-12-31 21:58:04 CST
 *   Universal time: Thu 2020-12-31 13:58:04 UTC
 *         RTC time: Wed 2021-01-06 07:49:33
 *        Time zone: Asia/Shanghai (CST, +0800)
 *      NTP enabled: n/a
 *  NTP synchronized: no
 *  RTC in local TZ: no
 *       DST active: n/a
 *
 *
 *
 *时区的基本概念
 *
 * GMT（Greenwich Mean Time），即格林威治标准时，是东西经零度的地方。人们将地球人为的分为24等份，每一等份为一个时区，每时区横跨经度15度，时间正好为1
 * 小时。往西一个时区，则减去一小时；往东一个时区，则加上一小时。中国在东经120度上，（东经120°-东经0°）所得度数再除以15，即得8。
 * UTC（Coordinated Universal Time），即世界协调时间，是经过平均太阳时(以格林威治时间GMT为准)
 * 、地轴运动修正后的新时标以及以「秒」为单位的国际原子时所综合精算而成的时间，计算过程相当严谨精密，因此若以「世界标准时间」的角度来说，UTC比GMT来得更加精准。UTC的本质强调的是比GMT
 * 更为精确的世界时间标准，不过对于现行表款来说，GMT与UTC的功能与精确度是没有差别的。
 * CST时间却同时可以代表如下 4 个不同的时区：
 * Central Standard Time (USA) UT-6:00
 * Central Standard Time (Australia) UT+9:30
 * China Standard Time UT+8:00
 * Cuba Standard Time UT-4:00
 * 可见，CST可以同时表示美国，澳大利亚，中国，古巴四个国家的标准时间。
 *
 * 以下不常见
 *
 * DST（Daylight Saving Time），夏日节约时间，指在夏天太阳升起的比较早时，将时钟拨快一小时，以提早日光的使用，在英国则称为夏令时间(Summer Time)。
 * PDT以及PST, PDT 是 Pacific Daylight Time 的缩写，美国夏季始于每年4月的第1个周日，止于每年10月的最后一个周日。夏令时比正常时间早一小时，与PDT时间相对应的是PST , Pacific
 * Standard Time 。 夏时制结束后就是PST（太平洋标准时间），西八区，与北京时间（东八区）时差-16个小时。
 *
 * 而java 中的时间
 *
 *  常见的是时间格式 new Date() 在中国默认是GMC+8   Wed Jan 06 15:26:27 GMT+08:00 2021
 *
 *  如果设置了
 *  TimeZone.setDefault(TimeZone.getTimeZone("UTC"));  Wed Jan 06 07:35:29 UTC 2021
 *  TimeZone.setDefault(TimeZone.getTimeZone("GMT"));  Wed Jan 06 07:35:08 GMT 2021
 *  那么这时候是格林威治时间
 *
 *
 *  可在启动时指定时区  java -Duser.timezone=GMT+08  可以添加时区参数
 *
 *
 *
 */
public class TimeZoneDemo {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        System.out.println(TimeZone.getDefault());
        System.out.println(new Date());
    }
}
