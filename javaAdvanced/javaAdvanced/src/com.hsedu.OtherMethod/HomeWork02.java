import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class HomeWork02 {
    public static void main(String[] args) {
        String name = "tom";
        String pwd = "123455";
        String email = "123@qq.com";
        try {
            userRigister(name, pwd, email);
            System.out.println("success");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }

    public static void userRigister(String name, String pwd, String email) {
        int userlens = name.length();
        if (!(userlens >= 2 && userlens <= 4)) {
            throw new RuntimeException("用户名长度不符");
        }

        if (!(isDigits(pwd) && pwd.length() == 6)) {
            throw new RuntimeException("密码错误");
        }

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(j > i && i > 0)) {
            throw new RuntimeException("邮箱错误");
        }
    }

    public static boolean isDigits(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' && chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
