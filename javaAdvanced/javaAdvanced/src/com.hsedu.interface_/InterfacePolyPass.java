package com.hsedu.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //IG ig = new IG();
        // �ӿڶ�̬��������
        //IH ih = new IH();
    }
}

interface IH {
}

// IG�̳���IH�ӿڣ���Teacherʵ����IG�ӿ�
// �൱��Teacherʵ����IH�ӿ�
interface IG extends IH {
}

class Teacher implements IG {

}
