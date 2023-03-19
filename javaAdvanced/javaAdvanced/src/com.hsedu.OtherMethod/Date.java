import java.text.SimpleDateFormat;
import java.util.*;

public class Date {
    public static void main(String[] args) {
        // 获取当前系统时间
        Date d1 = new Date();

        // 通过毫秒数得到时间
        Date d2 = new Date(988888);
        System.out.println(d1.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String format = sdf.format(d1);

        String s = "1996年01月01日";
        Date parse = sdf.parse(s);

    }
}
