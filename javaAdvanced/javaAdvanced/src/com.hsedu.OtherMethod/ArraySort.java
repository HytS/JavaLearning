import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        Arrays.sort(arr, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1 - i2;
            }
        });
    }
}
