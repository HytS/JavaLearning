package com.hsedu.map;

import java.util.HashMap;
import java.util.Map;

public class Map_ {
    /*    Map和Collection并列存在，用于保存具有映射关系的数据key-value
        * Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
        * Map中的key不允许重复，原因和HashSet一样，
        * Map中的value可以重复
        * Map的key可以为null，value也可以为null，注意key为null，只能有一个，value为null可以多个
        * 常用String类作为Map的key
        * key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value/


     */

    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("no1","tom");
        map.put("no2","dutch");
        map.put("no1","archar");
        map.put("no3","dutch");
        map.put(null,null);
        map.put(null,"hxa");
        map.put(null,"zhenni");
        map.put("no4",null);
        map.put("no5",null);

        map.put(1,"sedi");
        map.put(new Object(),"susan");
        System.out.println("map="+map);
        System.out.println(map.get("no4"));
    }

}
