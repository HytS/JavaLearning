public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {// �ⲿ��
    private int n1 = 10;

    public void method() {
        // ���ڽӿڵ������ڲ���
        // �ײ����� ���� Outer04$1
        // tiger �������� A������������ϵͳ����������ڲ���Outer04$1
        // jdk�ײ��ڴ��������ڲ���Outer04$1�����̴���Outer04$1ʵ��
        // ���Ұѵ�ַ���ظ�tiger
        // �����ڲ���ʹ��һ�ξͲ�����ʹ��
        A tiger = new A() {
            public void cry() {
                System.out.println("tiger cry");
            }
        };
        // getClass���Ի�ö������������
        System.out.println(tiger.getClass());

        // ��������Outer04$2
        // jack����������
        Father father = new Father("jack") {
            @Override
            public void test() {
                System.out.println("�����ڲ�����дtest����");
            }
        };

        father.test();

        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("eat bone");
            }
        };
        animal.eat();
    }
}

interface A {// �ӿ�
    public void cry();
}

class Father {// ��
    public Father(String name) {
        System.out.println("name=" + name);
    }

    public void test() {

    }
}

abstract class Animal {
    public void eat() {

    }
}
