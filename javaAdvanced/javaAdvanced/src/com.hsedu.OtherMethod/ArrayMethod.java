import java.util.Arrays;
import java.util.List;

public class ArrayMethod {
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 6, 7 };
        // ���ֲ���
        // ��������в��������Ԫ�أ�����-(low+1)
        // low��ָ�����ڵ�λ��
        int index = Arrays.binarySearch(arr, 5);
        Integer[] newAr = Arrays.copyOf(arr, arr.length);
        // ��������
        Integer[] num = new Integer[] { 2, 3, 5 };
        Arrays.fill(num, 99);

        // �ж���������Ԫ�������Ƿ���ȫһ��
        boolean equals = Arrays.equals(arr, newAr);
        // asList��һ��ֵ��ת����List
        List<Integer> asList = Arrays.asList(2, 3, 4, 5);
        System.out.println(asList);
    }
}
