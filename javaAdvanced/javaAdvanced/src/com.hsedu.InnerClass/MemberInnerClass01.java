import Outer08.Inner08;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        // �ⲿ����������ڲ���
        // Outer08.new Inner08();�൱�ڰ�new Inner08()����outer08��һ����Ա
        Outer08.Inner08 inner08 = Outer08.new Inner08();
        // ���ⲿ�����дһ�����������Է���Inner08�Ķ���
        Outer08.Inner08 gInner08 = outer08.getInner08instance();

        // Outer08 outer08 = new Outer08();
        // �ⲿ����������ڲ�����Ҫ��������
        outer08.say();
        // �ⲿ����������ڲ��෽ʽһ
        Outer08 outer082 = new Outer08();
        Inner08 inner081 = outer08.new Inner08();

        // ��ʽ2���ⲿ����дһ�����������Է���Inner08����
        Outer08.Inner08 inner082 = outer08.getInnerInstance();

    }
}

class Outer08 {
    private int age = 10;
    public String name;

    // ��������κ����η�
    final class Inner08 {// ��Ա�ڲ����Ƕ������ⲿ��ĳ�Աλ��
        int age = 100;

        public void say() {
            System.out.println("Outer's age=" + age);
            // ����ֱ�ӷ����ⲿ������г�Ա
            System.out.println(name);
            // ���ڲ�����ⲿ���г�Ա����ʱ��
            // �ڲ����Ծ�������ⲿ��
            System.out.println(Outer08.this.age);
        }

        public Inner08 getInner08instance() {
            return new Inner08();
        }

    }

    public Inner08 getInnerInstance() {
        return new Inner08();
    }

    public void t1() {
        Inner08 inner08 = new Inner08();
        // �ⲿ������ڲ���Ҫ��������
        inner08.say();

    }
}
