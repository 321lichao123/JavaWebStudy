package com.atguigu.threadllocal;

public class OrderDao {
    public static void createOrder() {
        String name = Thread.currentThread().getName();
        //System.out.println("OrderDao 当前线程["+name+"]中保存的数据是：" + ThreadloaclTest.data.get(name));
        System.out.println("OrderDao 当前线程["+name+"]中保存的数据是：" + ThreadloaclTest.threadLocal.get());
    }
}
