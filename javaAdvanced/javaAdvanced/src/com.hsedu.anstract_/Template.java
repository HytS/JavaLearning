abstract public class Template {
    public abstract void job();

    // ģ�����ģʽ
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("runtime=" + (end - start));
    }
}
