abstract public class Template {
    public abstract void job();

    // 模板设计模式
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("runtime=" + (end - start));
    }
}
