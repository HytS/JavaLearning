package com.hsedu.Set_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();
        hashSet.add("java");
        hashSet.add("c++");
        hashSet.add("java");

        System.out.println(hashSet);
        /* 源码分析
            //1、执行HashSet()
         * public HashSet() {
               map = new HashMap<>();
           }
            //2、执行add
          public boolean add(E e) {//e="java"
               //(static)PRESENT=new Object();
               return map.put(e, PRESENT)==null;
           }
          //3、执行put，该方法会执行hash（key）得到key对应的hash值，
          //算法return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
          public V put(K key, V value) {//key=“java” value=“PRESENT”
            return putVal(hash(key), key, value, false, true);
          }
          4、执行putVal
          （1）根据key，得到hash去计算该key应该存放到table表中的那个位置
          （2）判断p是否为null
          （2.1）如果p为null，表示还没有存放元素，就创建一个Node（key="java",value=PRESENT）
          （2.2）就放在该位置上tab[i] = newNode(hash, key, value, null);
              final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
                    Node<K,V>[] tab; Node<K,V> p; int n, i;//定义两个辅助变量
                    //table就是HasMap的一个数组，类型是Node[]
                    //if表示当前table大小是0，或是null，就进行第一次扩容，到16空间
                    if ((tab = table) == null || (n = tab.length) == 0)
                        n = (tab = resize()).length;
                    //根据key得到hash，去计算key应该存放到table的那个位置，并把这个位置的对象赋给p
                    if ((p = tab[i = (n - 1) & hash]) == null)
                        tab[i] = newNode(hash, key, value, null);
                    else {
                        Node<K,V> e; K k;
                        if (p.hash == hash &&
                        //如果当前索引位置对应链表的第一个元素和准备添加的key的hash值一样
                        //或者满足一下两个对象其中一个
                        //（1）准备加入的key和p指向的Node节点的key是同一个对象
                        //（2）不是同一个对象，但是内容相同（p指向Node节点的key的equals方法和准备加入key相比较之后）
                            ((k = p.key) == key || (key != null && key.equals(k))))
                            e = p;
                            //再判断p是不是一棵红黑树
                            //如果是一棵红黑树，就调用putTreeVal进行添加
                        else if (p instanceof TreeNode)
                            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                        else {//如果table对应索引位置，已经是一个链表就要用for循环比较
                        //（1）依次和该链表的每一个元素比较后，都不相同，则加入到该链表的最后
                        //注意：在把元素添加到链表后，立即判断该链表是否达到8个结点，如果达到就调用TreeifyBin
                        //对当前链表进行树化（转成红黑树）；注意在转成红黑树时，要进行判断，判断条件
                        //if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                        //            resize();
                        //如果上述条件成立，先table扩容
                        //只有上述条件不成立，才进行转成红黑树
                        //（2）依次和该链表的每一个元素比较过程中，如果有相同的情况直接break
                            for (int binCount = 0; ; ++binCount) {
                                if ((e = p.next) == null) {
                                    p.next = newNode(hash, key, value, null);
                                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                        treeifyBin(tab, hash);
                                    break;
                                }
                                if (e.hash == hash &&
                                    ((k = e.key) == key || (key != null && key.equals(k))))
                                    break;
                                p = e;
                            }
                        }
                        if (e != null) { // existing mapping for key
                            V oldValue = e.value;
                            if (!onlyIfAbsent || oldValue == null)
                                e.value = value;
                            afterNodeAccess(e);
                            return oldValue;
                        }
                    }
                    ++modCount;
                    if (++size > threshold)
                        resize();
                    afterNodeInsertion(evict);
                    return null;
            }


         */
    }
}
