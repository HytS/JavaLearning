public class ExtendsAndInterface {
    public static void main(String[] args) {

    }
}

// 猴子类
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
        System.out.println(name + "会爬树");
    }
}

// 继承
class LittleMonkey extends Monkey implements Bird {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + "学会飞");
    }
}

interface Bird {
    void fly();
}
