package com.hsedu.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //IG ig = new IG();
        // 接口多态传递现象
        //IH ih = new IH();
    }
}

interface IH {
}

// IG继承了IH接口，而Teacher实现了IG接口
// 相当于Teacher实现了IH接口
interface IG extends IH {
}

class Teacher implements IG {

}
