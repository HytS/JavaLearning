package com.hsedu.map;

import java.util.Hashtable;

public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("john",100);
//        hashtable.put(null,100);//�쳣
//        hashtable.put("john",null);
        hashtable.put("abg",100);
        hashtable.put("abg",200);
        System.out.println("table="+hashtable);
        //1.�ײ������� Hashtable$Entry[] ��ʼ��Ϊ11
        //2.�ٽ�ֵthreshold Ϊ8��11*0.75��
        //���ݻ���
        //ִ�з��� addEntry(hash,key,value,index) ���k-v��װ��Entry
        //��if(count>=threshold) ����ʱ��������
        //����  int newCapacity = (oldCapacity << 1) + 1;��������
    }
}
