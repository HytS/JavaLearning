import java.util.ArrayList;
import java.util.List;

public class List01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("zrt");
        list.add("yjl");
        list.add("jyy");
        list.add("jyy");
        System.out.println(list);

        System.out.println(list.get(3));
    }
}
