package com.hsedu.OtherMethod;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.chart.PieChart.Data;

public class LocalDate {
    public static void main(String[] args) {

        // now()获得当前日期时间的对象
        LocalDateTime ldt = LocalDateTime.now();
        // 日期格式类；使用DateTimeFormatter进行格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY年MM月dd日");
        String format = dateTimeFormatter.format(ldt);

        System.out.println(ldt.getHour());

        // 通过now()获取表示当前时间戳的对象
        Instant now = Instant.now();

        System.out.println(now);

        // 通过from可以把Instant转成Date
        Date date = Date.from(now);
        // 通过date的toInstant()可以把date转成Instant对象
//        Instant instant = date.toString();
    }
}