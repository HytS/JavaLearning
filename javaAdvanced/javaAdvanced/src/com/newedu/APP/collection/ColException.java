package com.newedu.APP.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ColException {
    public static void main(String[] args) {
        //���ϱ���ɾ��Ԫ�ؿ��ܳ��ֵĲ����޸��쳣
        ArrayList<String> list = new ArrayList<>();
        list.add("heima");
        list.add("heimb");
        list.add("heimb");
        list.add("heimc");
        list.add("heimd");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String ele  = iterator.next();
            if ("heimb".equals(ele)) {
                //����ɾ������쳣
//                list.remove(ele);
                //������ɾ��û����
                iterator.remove();
            }
        }
        System.out.println(list);

        //foreach����һ�߱���һ��ɾ��
        //forѭ��һ�߱���һ��ɾ��û�����ǰ���ǴӺ��濪ʼ����,�����Ų���©ɾ
        for (int i = list.size(); i >0; i--) {
            String ele = list.get(i);
            if ("heimb".equals(ele)) {
                list.remove(ele);
            }
        }
        System.out.println(list);
    }
}
