package com.hsedu.Oop_;

public class override {
    public static void main(String[] args) {
        A n1 = new A();
        n1.sum(10, 20);
        n1.sum(10, 20, 100);

    }
}

/**
 * Inneroverride
 */
public class A {
    /**
     * 重载条件：方法名必须相同，数据类型、顺序、个数至少一个不同
     * 
     * @param n1
     * @param n2
     * @return
     */
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int sum(int n1, int n2, int sum) {
        return sum + n1 + n2;
    }

}