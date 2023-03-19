import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("list" + i);
        }
        list.add(2, "abc2");
        System.out.println(list.get(4));
        list.remove(5);
        System.out.println(list);
        list.set(6, "sanguo");
        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
