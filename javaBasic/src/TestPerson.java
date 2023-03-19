public class TestPerson {
    public static void main(String[] args) {
        Person p = new Person("sw", 12);
        p.toString();
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public boolean compareTo(Person p) {
        return this.name.equals(name) && this.age == age;
    }
}
