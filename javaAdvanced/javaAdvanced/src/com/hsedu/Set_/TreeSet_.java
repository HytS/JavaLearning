package com.hsedu.Set_;


import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        //TreeSet treeSet = new TreeSet();
        //当使用无参构造器时，创建TreeSet，仍然是无序的
        //希望按照字符串大小进行排序
        //可以传入一个匿名内部类
        TreeSet treeSet = new TreeSet(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                //return ((String) o2).compareTo((String) o1);
                //按照字符串长度排序
                return ((String) o1).length()-((String) o2).length();
            }
        });

        treeSet.add("a");
        treeSet.add("baa");
        treeSet.add("cdaaa");
        treeSet.add("dddaaaa");

        System.out.println("treeSet="+treeSet);


        /*
        1.构造器把传入的比较器对象付给了TreeSet底层的TreeMap属性this.comparator = comparator;

           public TreeMap(Comparator<? super K> comparator) {
            this.comparator = comparator;
        }

        2.
        if (cpr != null) {
            do {//遍历所有的key，给当前key找到合适位置
                parent = t;
                //动态绑定到匿名内部类
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else//如果遍历过程中，发信准备添加的key和当前已有的key相等，就直接返回
                    return t.setValue(value);
            } while (t != null);
        * */

    }
}
