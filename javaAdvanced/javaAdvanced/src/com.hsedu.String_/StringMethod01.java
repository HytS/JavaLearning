public class StringMethod01 {
    public static void main(String[] args) {
        String str = new String("abcab");
        String str1 = new String("abd");
        // 格式字符串
        String info = "第一个字符串是%s,第二个字符串是%s";
        String info2 = String.format(info, str, str1);
        String poem = "abc,def,hij,kmn";
        String file = "e:\\aaa\\bbb";
        // 忽略大小写的判断内容是否相同
        str.equalsIgnoreCase("ABCAB");
        // 判断str第一次出现在那个位置
        str.indexOf("ab");
        // 截取字符串从0开始截取，截取到第2个字符 //b
        str.substring(0, 2);
        // 从1开始截取字符串
        str.substring(1);
        // 将abcab和edf连接起来
        str.concat("edf").concat("ghj");
        // 用"edf"代替"abc"
        str.replace("abc", "edf");
        // 用，将字符串分割//abcdefhjklmn
        poem.split(",");
        // 需要用到转义字符\\
        file.split("\\\\");

        // 将字符串转成字符数组
        str.toCharArray();
        // 将两个字符串相互比较，前者大返回1，后者大返回-1，相同返回0
        // 如果长度相同，并且每个字符都相同返回0；
        // 如果长度相同或不相同，但在进行比较时，可以区分大小；
        // 如果前面的部分都相同，就返回str1.len-str2.len
        System.out.println(str.compareTo(str1));

    }
}
