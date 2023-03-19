public class PolyParameter {
    public static void main(String[] args) {
        Worker w = new Worker("tom", 290);
        Manager m = new Manager("tpm", 1200, 399);
        PolyParameter parameter = new PolyParameter();
        parameter.showEmpAnnual(w);
    }

}

class Test {

    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnu());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker) {
            Worker w = new Worker();
            w.work();
        } else if (e instanceof Manager) {
            Worker w = new Worker();
            w.manage();
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public double getAnnu() {
        return salary * 12;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class Worker extends Employee {

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {

    }

    @Override
    public double getAnnu() {
        // TODO Auto-generated method stub
        return super.getAnnu();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage() {

    }

    @Override
    public double getAnnu() {
        // TODO Auto-generated method stub
        return super.getAnnu() + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}