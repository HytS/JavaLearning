public class anonymousInnerClassDetail {
    public static void main(String[] args) {

    }
}

class Outer05 {
    private int n1 = 2;

    public void f1() {
        Person p1 = new Person() {
            int n1 = 100;

            // �����ڲ�����дhi
            @Override
            public void hi() {
                System.out.println("rewrite hi method");
                System.out.println("n1=" + n1 + "Outer05 ni" + Outer05.this.n1);
            }
        };

        p1.hi();// ��̬�󶨣�����������Outer05$1
        // *******
        // Ҳ����ֱ�ӵ���,��Ϊ�����ڲ��౾��Ҳ�Ƿ��ض���
        // class �����ڲ��� extends Person{}
        new Person() {
            @Override
            public void hi() {
                System.out.println("hi again");
            }
        }.hi();
    }
}

class Person {
    public void hi() {
        System.out.println("hi");
    }
}
