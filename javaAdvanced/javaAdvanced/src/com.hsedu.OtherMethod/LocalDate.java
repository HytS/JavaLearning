package com.hsedu.OtherMethod;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.chart.PieChart.Data;

public class LocalDate {
    public static void main(String[] args) {

        // now()��õ�ǰ����ʱ��Ķ���
        LocalDateTime ldt = LocalDateTime.now();
        // ���ڸ�ʽ�ࣻʹ��DateTimeFormatter���и�ʽ��
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY��MM��dd��");
        String format = dateTimeFormatter.format(ldt);

        System.out.println(ldt.getHour());

        // ͨ��now()��ȡ��ʾ��ǰʱ����Ķ���
        Instant now = Instant.now();

        System.out.println(now);

        // ͨ��from���԰�Instantת��Date
        Date date = Date.from(now);
        // ͨ��date��toInstant()���԰�dateת��Instant����
//        Instant instant = date.toString();
    }
}