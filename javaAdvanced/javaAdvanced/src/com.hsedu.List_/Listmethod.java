import java.util.ArrayList;
import java.util.List;

public class Listmethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("john");
        list.add("ABgai");
        list.add("jake");
        // 在index位置插入元素
        list.add(1, "tom");

        List list2 = new ArrayList();
        list2.add("ase");
        list2.add("mary");
        // boolean addAll(int index,Collection eles)
        // 从index位置插入eles中的所有元素
        list.addAll(1, list2);
        list.add("tom");

        // Object get(int index) 获取指定index位置的元素
        // 返回obj第一次在集合中出现的位置
        System.out.println(list);
        System.out.println(list.indexOf("tom"));
        // 返回obj最后一次出现的位置
        System.out.println(list);
        System.out.println(list.lastIndexOf("tom"));

        // Object remove(int index)
        // 移除指定index位置的元素，并返回此元素
        list.remove(1);
        System.out.println(list);

        List list3 = new ArrayList();
        list.add("tom");
        // Object set(int index,Object ele)
        // 设定指定index位置的元素为Object ele，相当于是替换
        list.set(1, "marybesi");
        System.out.println(list);

        // List subList(int fromIndex,int toIndex) 返回从fromIndex到toIndex的子集合
        // [fromIndex,toIndex)
        List reList = list.subList(2, 5);
        System.out.println(reList);
    }
}
