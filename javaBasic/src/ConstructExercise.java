public class ConstructExercise {
    public static void main(String[] args) throws Exception {
        Person p1Person = new Person();
        Person p2Person = new Person("jsjj", 28);

    }
}

class Person {
    int age;
    String name;

    public Person() {
        age = 18;
    }

    public Person(String pName, int pAge) {
        this.age = pAge;
        this.name = pName;
    }
}