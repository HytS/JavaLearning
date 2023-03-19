import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListFor {
    public static void main(String[] args) {
        // List接口的实现子类
        // List list = new ArrayList<>();
        List list = new Vector();
        // List list = new LinkedList<>();
        list.add("俘虏八宝鸭");
        list.add("tom");
        list.add("tony");

        // 1、迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        // 2、增强for
        for (Object obj : list) {
            System.out.println(obj);
        }

        // 3、普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
