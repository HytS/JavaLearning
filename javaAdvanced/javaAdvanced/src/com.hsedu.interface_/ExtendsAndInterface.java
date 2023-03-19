public class ExtendsAndInterface {
    public static void main(String[] args) {

    }
}

// ������
class Monkey {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing(String name) {
        System.out.println(name + "������");
    }
}

// �̳�
class LittleMonkey extends Monkey implements Bird {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + "ѧ���");
    }
}

interface Bird {
    void fly();
}
