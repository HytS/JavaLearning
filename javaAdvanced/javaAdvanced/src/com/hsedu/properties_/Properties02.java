package com.hsedu.properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        properties.load(new FileReader("src\\mysql.properties"));
        properties.list(System.out);
        String user=properties.getProperty("user");
        String pwd=properties.getProperty("pwd");

    }
}
