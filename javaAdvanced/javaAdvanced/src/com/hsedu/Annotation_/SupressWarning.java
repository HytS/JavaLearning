import java.util.ArrayList;
import java.util.List;

public class SupressWarning {

    // 当不希望看到这些警告的时候，可以使用SupressWarnings注解来抑制警告信息
    // 在{""}中，可以写入希望一致警告信息
    // unchecked 是忽略没有检查的警告
    /*
     * rawtypes是忽略没有指定泛型的警告（传参时没有指定泛型的警告）
     * unused 是忽略没有使用某个变量的警告错误
     */

    @SuppressWarnings({ "all" })
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        System.out.println(list.get(0));
    }
}
