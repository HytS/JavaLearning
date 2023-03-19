public class ToString {
    public static void main(String[] args) {
        Monster monster = new Monster("st", "swep", 2333.0);

    }
}

class Monster {
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.job = job;
        this.name = name;
        this.sal = sal;
    }

    // ÷ÿ–¥toString
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name=" + name + "job=" + job + "sal=" + sal;
    }
}
