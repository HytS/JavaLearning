public class StringBuffermethod {
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("hello");
        // s.append(str).append(str1); 把s和str和str1等字符串连接起来
        stringBuffer.append("world");
        // delete(start,end); 删除索引为[start,end)处的字符
        stringBuffer.delete(5, 10);
        // replace(m,n,str); 用str代替m-n的字符[m,n)
        stringBuffer.replace(5, 9, "hsedu");
        // indexOf(str) 查找指定子串在字符串第一次出现的索引，如果找不到返回-1
        stringBuffer.indexOf("hs");
        // insert(m,str) 在索引为m的位置插入str，原来索引为m的内容自动后移
        stringBuffer.insert(10, "yeyeye");
        // 获取长度
        System.out.println(stringBuffer.length());
    }
}
