public class abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
    }

    /*
     * ���󷽷�����û��ʵ�ֵķ�������û�з�����
     * ��һ�����д��ڳ��󷽷�ʱ����Ҫ����������Ϊabstract��
     * һ����˵��������ᱻ�̳У�����������ʵ�ֳ��󷽷�
     */

    public abstract void eat();
}
