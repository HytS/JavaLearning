public class homeWork03 {
    public static void main(String[] args) {

    }

    public void printName(String str) {
        if (str == null) {
            return;
        }
        String[] names = str.split(' ');
        if (names.length != 3) {
            System.out.println("false");
            return;
        }
        String.format("%s,%s.%c", names[2], names[0], names[1].toUpperCase().charAt(0));
    }
}
