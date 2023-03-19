import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("tom", 12));
        list.add(new Dog("jerry", 12));
        list.add(new Dog("jo", 129));
        // 使用for增强
        for (Object dog : list) {
            System.out.println("dog=" + dog);
        }
        // 使用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog = iterator.next();
            System.out.println(dog);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(String name, int age) {

        return "name=" + name + "age=" + age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
