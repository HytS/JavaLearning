package com.hsedu.Set_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();
        hashSet.add("java");
        hashSet.add("c++");
        hashSet.add("java");

        System.out.println(hashSet);
        /* Դ�����
            //1��ִ��HashSet()
         * public HashSet() {
               map = new HashMap<>();
           }
            //2��ִ��add
          public boolean add(E e) {//e="java"
               //(static)PRESENT=new Object();
               return map.put(e, PRESENT)==null;
           }
          //3��ִ��put���÷�����ִ��hash��key���õ�key��Ӧ��hashֵ��
          //�㷨return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
          public V put(K key, V value) {//key=��java�� value=��PRESENT��
            return putVal(hash(key), key, value, false, true);
          }
          4��ִ��putVal
          ��1������key���õ�hashȥ�����keyӦ�ô�ŵ�table���е��Ǹ�λ��
          ��2���ж�p�Ƿ�Ϊnull
          ��2.1�����pΪnull����ʾ��û�д��Ԫ�أ��ʹ���һ��Node��key="java",value=PRESENT��
          ��2.2���ͷ��ڸ�λ����tab[i] = newNode(hash, key, value, null);
              final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
                    Node<K,V>[] tab; Node<K,V> p; int n, i;//����������������
                    //table����HasMap��һ�����飬������Node[]
                    //if��ʾ��ǰtable��С��0������null���ͽ��е�һ�����ݣ���16�ռ�
                    if ((tab = table) == null || (n = tab.length) == 0)
                        n = (tab = resize()).length;
                    //����key�õ�hash��ȥ����keyӦ�ô�ŵ�table���Ǹ�λ�ã��������λ�õĶ��󸳸�p
                    if ((p = tab[i = (n - 1) & hash]) == null)
                        tab[i] = newNode(hash, key, value, null);
                    else {
                        Node<K,V> e; K k;
                        if (p.hash == hash &&
                        //�����ǰ����λ�ö�Ӧ����ĵ�һ��Ԫ�غ�׼����ӵ�key��hashֵһ��
                        //��������һ��������������һ��
                        //��1��׼�������key��pָ���Node�ڵ��key��ͬһ������
                        //��2������ͬһ�����󣬵���������ͬ��pָ��Node�ڵ��key��equals������׼������key��Ƚ�֮��
                            ((k = p.key) == key || (key != null && key.equals(k))))
                            e = p;
                            //���ж�p�ǲ���һ�ú����
                            //�����һ�ú�������͵���putTreeVal�������
                        else if (p instanceof TreeNode)
                            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                        else {//���table��Ӧ����λ�ã��Ѿ���һ�������Ҫ��forѭ���Ƚ�
                        //��1�����κ͸������ÿһ��Ԫ�رȽϺ󣬶�����ͬ������뵽����������
                        //ע�⣺�ڰ�Ԫ����ӵ�����������жϸ������Ƿ�ﵽ8����㣬����ﵽ�͵���TreeifyBin
                        //�Ե�ǰ�������������ת�ɺ��������ע����ת�ɺ����ʱ��Ҫ�����жϣ��ж�����
                        //if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                        //            resize();
                        //�������������������table����
                        //ֻ�������������������Ž���ת�ɺ����
                        //��2�����κ͸������ÿһ��Ԫ�رȽϹ����У��������ͬ�����ֱ��break
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
