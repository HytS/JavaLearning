import java.text.SimpleDateFormat;
import java.util.*;

public class Date {
    public static void main(String[] args) {
        // ��ȡ��ǰϵͳʱ��
        Date d1 = new Date();

        // ͨ���������õ�ʱ��
        Date d2 = new Date(988888);
        System.out.println(d1.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
        String format = sdf.format(d1);

        String s = "1996��01��01��";
        Date parse = sdf.parse(s);

    }
}
