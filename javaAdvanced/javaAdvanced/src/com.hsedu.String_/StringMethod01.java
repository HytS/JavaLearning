public class StringMethod01 {
    public static void main(String[] args) {
        String str = new String("abcab");
        String str1 = new String("abd");
        // ��ʽ�ַ���
        String info = "��һ���ַ�����%s,�ڶ����ַ�����%s";
        String info2 = String.format(info, str, str1);
        String poem = "abc,def,hij,kmn";
        String file = "e:\\aaa\\bbb";
        // ���Դ�Сд���ж������Ƿ���ͬ
        str.equalsIgnoreCase("ABCAB");
        // �ж�str��һ�γ������Ǹ�λ��
        str.indexOf("ab");
        // ��ȡ�ַ�����0��ʼ��ȡ����ȡ����2���ַ� //b
        str.substring(0, 2);
        // ��1��ʼ��ȡ�ַ���
        str.substring(1);
        // ��abcab��edf��������
        str.concat("edf").concat("ghj");
        // ��"edf"����"abc"
        str.replace("abc", "edf");
        // �ã����ַ����ָ�//abcdefhjklmn
        poem.split(",");
        // ��Ҫ�õ�ת���ַ�\\
        file.split("\\\\");

        // ���ַ���ת���ַ�����
        str.toCharArray();
        // �������ַ����໥�Ƚϣ�ǰ�ߴ󷵻�1�����ߴ󷵻�-1����ͬ����0
        // ���������ͬ������ÿ���ַ�����ͬ����0��
        // ���������ͬ����ͬ�����ڽ��бȽ�ʱ���������ִ�С��
        // ���ǰ��Ĳ��ֶ���ͬ���ͷ���str1.len-str2.len
        System.out.println(str.compareTo(str1));

    }
}
