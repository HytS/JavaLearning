import java.util.ArrayList;
import java.util.List;

public class SupressWarning {

    // ����ϣ��������Щ�����ʱ�򣬿���ʹ��SupressWarningsע�������ƾ�����Ϣ
    // ��{""}�У�����д��ϣ��һ�¾�����Ϣ
    // unchecked �Ǻ���û�м��ľ���
    /*
     * rawtypes�Ǻ���û��ָ�����͵ľ��棨����ʱû��ָ�����͵ľ��棩
     * unused �Ǻ���û��ʹ��ĳ�������ľ������
     */

    @SuppressWarnings({ "all" })
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        System.out.println(list.get(0));
    }
}
