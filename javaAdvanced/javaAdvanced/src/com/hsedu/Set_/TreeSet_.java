package com.hsedu.Set_;


import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        //TreeSet treeSet = new TreeSet();
        //��ʹ���޲ι�����ʱ������TreeSet����Ȼ�������
        //ϣ�������ַ�����С��������
        //���Դ���һ�������ڲ���
        TreeSet treeSet = new TreeSet(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                //return ((String) o2).compareTo((String) o1);
                //�����ַ�����������
                return ((String) o1).length()-((String) o2).length();
            }
        });

        treeSet.add("a");
        treeSet.add("baa");
        treeSet.add("cdaaa");
        treeSet.add("dddaaaa");

        System.out.println("treeSet="+treeSet);


        /*
        1.�������Ѵ���ıȽ������󸶸���TreeSet�ײ��TreeMap����this.comparator = comparator;

           public TreeMap(Comparator<? super K> comparator) {
            this.comparator = comparator;
        }

        2.
        if (cpr != null) {
            do {//�������е�key������ǰkey�ҵ�����λ��
                parent = t;
                //��̬�󶨵������ڲ���
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else//������������У�����׼����ӵ�key�͵�ǰ���е�key��ȣ���ֱ�ӷ���
                    return t.setValue(value);
            } while (t != null);
        * */

    }
}
