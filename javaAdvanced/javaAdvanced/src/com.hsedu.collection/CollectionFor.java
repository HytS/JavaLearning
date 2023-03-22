package com.hsedu.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("sanguo", "lgz", 20));
        col.add(new Book("xlfd", "gl", 23.3));
        col.add(new Book("hlm", "cxq", 20.1));

        // 使用增强for，在Collection集合
        // 增强for，底层仍旧时迭代器
        // 增强for可以理解为简化版本的迭代器
        for (Object bookObject : col) {
            System.out.println(bookObject);
        }

        // 增强for，也可以直接在数组中使用
        int[] nums = { 1, 2, 4, 6 };
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
