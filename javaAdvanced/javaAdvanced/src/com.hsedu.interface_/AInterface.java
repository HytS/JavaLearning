public interface AInterface {
    public int n1 = 200;

    // 接口中抽象方法可以省略abstract关键字
    public void hi();

    default public void ok() {
        System.out.println("ok");

    }

    public static void cry() {
        System.out.println("cry");
    }
}
