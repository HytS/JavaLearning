package com.hsedu.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("sanguo", "lgz", 20));
        col.add(new Book("xlfd", "gl", 23.3));
        col.add(new Book("hlm", "cxq", 20.1));

        // ʹ����ǿfor����Collection����
        // ��ǿfor���ײ��Ծ�ʱ������
        // ��ǿfor�������Ϊ�򻯰汾�ĵ�����
        for (Object bookObject : col) {
            System.out.println(bookObject);
        }

        // ��ǿfor��Ҳ����ֱ����������ʹ��
        int[] nums = { 1, 2, 4, 6 };
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
