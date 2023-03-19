public class Interface04 {
    public static void main(String[] args) {
        // 接口不能被实例化
        // IA ia=new IA();
    }
}

interface IA {
    // == void aa();
    abstract void aa();

    void say();

    void hi();

}

class Cat implements IA {
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }

    @Override
    public void aa() {

    }
}