package com.hsedu.interface_;

public class Interface03 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);
    }

    public static void t(DBInterface dbInterface) {
        dbInterface.connection();
        dbInterface.close();
    }
}

// 接口
 interface DBInterface {
    public void connection();

    public void close();
}

// 实现接口
 class MysqlDB implements DBInterface {
    @Override
    public void connection() {
        System.out.println("connection");
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}

// 实现接口
 class Oracle implements DBInterface {
    @Override
    public void connection() {
        System.out.println("connection");
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}