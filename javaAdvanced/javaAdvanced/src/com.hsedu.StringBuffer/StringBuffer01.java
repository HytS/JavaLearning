package com.hsedu.StringBuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
        // ����һ����СΪ16��char[] ,���ڴ���ַ�����
        StringBuffer buffer = new StringBuffer();

        // ͨ��������ָ�� char[] ��С
        StringBuffer stringBuffer = new StringBuffer(5);

        // ͨ����һ��String ����StringBuffer
        // char[] �����Сstr.length+16
        StringBuffer hello = new StringBuffer("hello");

        // String-->StringBuffer
        // ʹ�ù����������ص���StringBuffer���󣬶�str������Ӱ��
        String str = "hello";
        StringBuffer strbuf = new StringBuffer(str);
        // ʹ��append����
        StringBuffer strbuf2 = new StringBuffer();
        strbuf2 = strbuf2.append(str);

        // StirngBuffer-->String
        // ��ʽ1��ʹ��StringBuffer���ṩ��toString����
        StringBuffer stringBuffer2 = new StringBuffer("hsedu");
        String s1;
        s1 = stringBuffer2.toString();

        // ��ʽ2��ʹ�ù�����
        String s2 = new String(stringBuffer2);
    }
}
