import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListFor {
    public static void main(String[] args) {
        // List�ӿڵ�ʵ������
        // List list = new ArrayList<>();
        List list = new Vector();
        // List list = new LinkedList<>();
        list.add("��²�˱�Ѽ");
        list.add("tom");
        list.add("tony");

        // 1��������
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        // 2����ǿfor
        for (Object obj : list) {
            System.out.println(obj);
        }

        // 3����ͨfor
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
