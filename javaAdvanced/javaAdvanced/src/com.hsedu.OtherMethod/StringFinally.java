public class StringFinally {
    public static void main(String[] args) {
        String s1 = "hsedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        // F a,b指向name，name指向常量池中的"hsedu"
        System.out.println(a == b);
        // aniaml类没有重写equals，F
        System.out.println(a.equals(b));
        // T
        System.out.println(a.name = b.name);

        // s4指向vlaue数组，value指向"hsedu"
        String s4 = new String("hsedu");
        String s5 = "hsedu";
        // F
        System.out.println(s1 == s4);
        // F
        System.out.println(s4 == s5);

        // 字符串+变量，需要stirngBuilder，把hello加进去再把s1加进去，
        // 然后在堆中创建一个value把地址返给t1
        // 如果都是常量则会优化
        String t1 = "hello" + s1;
        String t2 = "hellohsedu";
        // T
        System.out.println(t1.intern() == t2);
    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}
