public class InterfacePolyPara {
    public static void main(String[] args) {
        IF if01 = new IF();
        if01 = new Cat();
        if01 = new Monster();

        // 继承体现多态
        // 父类类型的变量a可以指向继承AAA的子类的对象实例
        AAA a = new AAA();
        a = new CCC();

        // 多态数组 接口类型数组
        Usb[] usb01 = new Usb[2];
        usb01[0] = new Phone();
        usb01[1] = new camera();
        for (int i = 0; i < usb01.length; i++) {
            usb01[i].work();
            if (usb01[i] instanceof Phone) {
                ((Phone) usb01[i]).call();
            }
        }
    }
}

// 接口体现多态
interface IF {
}

class Cat implements IF {
}

class Monster implements IF {
}

// 继承体现多态
class AAA {
}

class BBB extends AAA {
}

class CCC extends AAA {
}

interface Usb {
    void work();
}

class Phone implements Usb {
    @Override
    public void work() {
        System.out.println("phone work");
    }

    public void call() {
        System.out.println();
    }
}

class camera implements Usb {
    @Override
    public void work() {
        System.out.println("camera work");
    }
}
