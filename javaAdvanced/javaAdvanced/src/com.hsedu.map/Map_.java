package com.hsedu.map;

import java.util.HashMap;
import java.util.Map;

public class Map_ {
    /*    Map��Collection���д��ڣ����ڱ������ӳ���ϵ������key-value
        * Map�е�key��value�������κ��������͵����ݣ����װ��HashMap$Node������
        * Map�е�key�������ظ���ԭ���HashSetһ����
        * Map�е�value�����ظ�
        * Map��key����Ϊnull��valueҲ����Ϊnull��ע��keyΪnull��ֻ����һ����valueΪnull���Զ��
        * ����String����ΪMap��key
        * key��value֮����ڵ���һ��һ��ϵ����ͨ��ָ����key�����ҵ���Ӧ��value/


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
