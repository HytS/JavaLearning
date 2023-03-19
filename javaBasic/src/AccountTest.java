public class AccountTest {
    public static void main(String[] args) {

    }
}

class Account {
    String name;
    double balance;
    String pwd;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("balance must be 20");
        }
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}