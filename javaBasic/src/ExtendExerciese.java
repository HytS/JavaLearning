public class ExtendExerciese {
    public static void main(String[] args) {
        PC pc = new PC();
        Notepad notepad = new Notepad();
        pc.printInfo();
    }
}

class Computer {
    String cpu;
    String ram;
    String harddrive;

    public Computer(String cpu, String ram, String harddrive) {
        this.cpu = cpu;
        this.ram = ram;
        this.harddrive = harddrive;
    }

    public String getDetail() {
        return cpu + ' ' + ram + ' ' + harddrive;
    }
}

class PC extends Computer {
    String brand;

    public PC(String cpu, String ram, String harddrive, String brand) {
        super(cpu, ram, harddrive);
        this.brand = brand;
    }

    public void printInfo() {
        System.out.println(getDetail() + "brand=" + brand);
    }
}

class Notepad extends Computer {
    String color;

    public Notepad(String cpu, String ram, String harddrive, String color) {
        super(cpu, ram, harddrive);
        this.color = color;
    }
}

class Test {

}
