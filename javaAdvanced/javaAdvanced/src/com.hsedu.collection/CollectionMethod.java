package com.hsedu.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings({ "all" })
    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        // ��ӵ���Ԫ��
        list.add("jack");
        list.add(10);// �Զ�װ�� list.add(new Integer(10))
        list.add(true);

        // remove ɾ��Ԫ��
        list.remove(0);// ������ɾ��Ԫ�أ���ɾ����һ��Ԫ��
        list.remove("jack");
        System.out.println(list);

        // contains �ж��Ƿ��������
        System.out.println(list.contains(10));

        // size�жϴ�С
        System.out.println(list.size());

        // isEmpty �п�
        System.out.println(list.isEmpty());

        // clear ��ռ���
        list.clear();
        System.out.println(list);

        ArrayList list2 = new ArrayList();
        list2.add("three countryies");
        list2.add("��¥��");
        // addAll ��Ӷ��Ԫ��
        list.addAll(list2);
        System.out.println(list);

        // containsAll ���Ҷ��Ԫ���Ƿ����
        System.out.println(list.containsAll(list2));

        // removeAll ɾ������Ԫ��
        list.add("��ի");
        list.removeAll(list2);
        System.out.println(list);

    }
}
