package com.hsedu.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings({ "all" })
    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        // 添加单个元素
        list.add("jack");
        list.add(10);// 自动装箱 list.add(new Integer(10))
        list.add(true);

        // remove 删除元素
        list.remove(0);// 按索引删除元素，即删除第一个元素
        list.remove("jack");
        System.out.println(list);

        // contains 判断是否包含对象
        System.out.println(list.contains(10));

        // size判断大小
        System.out.println(list.size());

        // isEmpty 判空
        System.out.println(list.isEmpty());

        // clear 清空集合
        list.clear();
        System.out.println(list);

        ArrayList list2 = new ArrayList();
        list2.add("three countryies");
        list2.add("红楼梦");
        // addAll 添加多个元素
        list.addAll(list2);
        System.out.println(list);

        // containsAll 查找多个元素是否存在
        System.out.println(list.containsAll(list2));

        // removeAll 删除所有元素
        list.add("聊斋");
        list.removeAll(list2);
        System.out.println(list);

    }
}
