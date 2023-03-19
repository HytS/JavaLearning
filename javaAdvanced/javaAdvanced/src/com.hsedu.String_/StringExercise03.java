public class StringExercise03 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hsedu";
        Person p2 = new Person();
        p2.name = "hsedu";
        System.out.println(p1.name.equals(p2.name));// t
        System.out.println(p1.name == p2.name);// t
        System.out.println(p1.name == "hsedu");// t

    }
}

class Person {
    String name;
}
