package com.hsedu.StringBuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
        // 创建一个大小为16的char[] ,用于存放字符内容
        StringBuffer buffer = new StringBuffer();

        // 通过构造器指定 char[] 大小
        StringBuffer stringBuffer = new StringBuffer(5);

        // 通过给一个String 创建StringBuffer
        // char[] 数组大小str.length+16
        StringBuffer hello = new StringBuffer("hello");

        // String-->StringBuffer
        // 使用构造器，返回的是StringBuffer对象，对str本身并无影响
        String str = "hello";
        StringBuffer strbuf = new StringBuffer(str);
        // 使用append方法
        StringBuffer strbuf2 = new StringBuffer();
        strbuf2 = strbuf2.append(str);

        // StirngBuffer-->String
        // 方式1：使用StringBuffer类提供的toString方法
        StringBuffer stringBuffer2 = new StringBuffer("hsedu");
        String s1;
        s1 = stringBuffer2.toString();

        // 方式2：使用构造器
        String s2 = new String(stringBuffer2);
    }
}
