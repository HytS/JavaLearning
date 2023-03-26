package com.hsedu.map;

import java.util.Hashtable;

public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("john",100);
//        hashtable.put(null,100);//异常
//        hashtable.put("john",null);
        hashtable.put("abg",100);
        hashtable.put("abg",200);
        System.out.println("table="+hashtable);
        //1.底层有数组 Hashtable$Entry[] 初始化为11
        //2.临界值threshold 为8（11*0.75）
        //扩容机制
        //执行方法 addEntry(hash,key,value,index) 添加k-v封装到Entry
        //当if(count>=threshold) 满足时进行扩容
        //按照  int newCapacity = (oldCapacity << 1) + 1;进行扩容
    }
}
