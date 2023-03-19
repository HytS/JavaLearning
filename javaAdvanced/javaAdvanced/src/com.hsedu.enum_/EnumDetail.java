public class EnumDetail {
    public static void main(String[] args) {

    }
}

interface C {
    public void sayhi();
}

enum A implements C {
    CLASSMUSIC;

    public void sayhi() {
        System.out.println("hello");
    }
}
