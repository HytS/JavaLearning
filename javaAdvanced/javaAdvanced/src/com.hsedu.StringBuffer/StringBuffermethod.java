public class StringBuffermethod {
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("hello");
        // s.append(str).append(str1); ��s��str��str1���ַ�����������
        stringBuffer.append("world");
        // delete(start,end); ɾ������Ϊ[start,end)�����ַ�
        stringBuffer.delete(5, 10);
        // replace(m,n,str); ��str����m-n���ַ�[m,n)
        stringBuffer.replace(5, 9, "hsedu");
        // indexOf(str) ����ָ���Ӵ����ַ�����һ�γ��ֵ�����������Ҳ�������-1
        stringBuffer.indexOf("hs");
        // insert(m,str) ������Ϊm��λ�ò���str��ԭ������Ϊm�������Զ�����
        stringBuffer.insert(10, "yeyeye");
        // ��ȡ����
        System.out.println(stringBuffer.length());
    }
}
