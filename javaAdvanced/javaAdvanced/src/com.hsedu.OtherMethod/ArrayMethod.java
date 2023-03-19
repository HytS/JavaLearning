import java.util.Arrays;
import java.util.List;

public class ArrayMethod {
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 6, 7 };
        // 二分查找
        // 如果数组中不存在这个元素，返回-(low+1)
        // low是指本该在的位置
        int index = Arrays.binarySearch(arr, 5);
        Integer[] newAr = Arrays.copyOf(arr, arr.length);
        // 数组的填充
        Integer[] num = new Integer[] { 2, 3, 5 };
        Arrays.fill(num, 99);

        // 判断两个数组元素内容是否完全一致
        boolean equals = Arrays.equals(arr, newAr);
        // asList将一组值，转换成List
        List<Integer> asList = Arrays.asList(2, 3, 4, 5);
        System.out.println(asList);
    }
}
