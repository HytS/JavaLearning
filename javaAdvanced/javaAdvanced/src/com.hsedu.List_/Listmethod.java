import java.util.ArrayList;
import java.util.List;

public class Listmethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("john");
        list.add("ABgai");
        list.add("jake");
        // ��indexλ�ò���Ԫ��
        list.add(1, "tom");

        List list2 = new ArrayList();
        list2.add("ase");
        list2.add("mary");
        // boolean addAll(int index,Collection eles)
        // ��indexλ�ò���eles�е�����Ԫ��
        list.addAll(1, list2);
        list.add("tom");

        // Object get(int index) ��ȡָ��indexλ�õ�Ԫ��
        // ����obj��һ���ڼ����г��ֵ�λ��
        System.out.println(list);
        System.out.println(list.indexOf("tom"));
        // ����obj���һ�γ��ֵ�λ��
        System.out.println(list);
        System.out.println(list.lastIndexOf("tom"));

        // Object remove(int index)
        // �Ƴ�ָ��indexλ�õ�Ԫ�أ������ش�Ԫ��
        list.remove(1);
        System.out.println(list);

        List list3 = new ArrayList();
        list.add("tom");
        // Object set(int index,Object ele)
        // �趨ָ��indexλ�õ�Ԫ��ΪObject ele���൱�����滻
        list.set(1, "marybesi");
        System.out.println(list);

        // List subList(int fromIndex,int toIndex) ���ش�fromIndex��toIndex���Ӽ���
        // [fromIndex,toIndex)
        List reList = list.subList(2, 5);
        System.out.println(reList);
    }
}
