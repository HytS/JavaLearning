public class StringFinally {
    public static void main(String[] args) {
        String s1 = "hsedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        // F a,bָ��name��nameָ�������е�"hsedu"
        System.out.println(a == b);
        // aniaml��û����дequals��F
        System.out.println(a.equals(b));
        // T
        System.out.println(a.name = b.name);

        // s4ָ��vlaue���飬valueָ��"hsedu"
        String s4 = new String("hsedu");
        String s5 = "hsedu";
        // F
        System.out.println(s1 == s4);
        // F
        System.out.println(s4 == s5);

        // �ַ���+��������ҪstirngBuilder����hello�ӽ�ȥ�ٰ�s1�ӽ�ȥ��
        // Ȼ���ڶ��д���һ��value�ѵ�ַ����t1
        // ������ǳ�������Ż�
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
