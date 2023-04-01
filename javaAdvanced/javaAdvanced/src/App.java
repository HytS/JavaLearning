import java.io.FileReader;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        properties.load(new FileReader("src\\mysql02.properties"));
        properties.list(System.out);
        String user=properties.getProperty("user");
        String pwd=properties.getProperty("pwd");
    }
}
