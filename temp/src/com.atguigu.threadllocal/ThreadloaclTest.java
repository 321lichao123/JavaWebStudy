package com.atguigu.threadllocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ThreadloaclTest {
    public static Map<String, Object> data = new Hashtable<>();
    public static Random random = new Random();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static class Task implements Runnable {

        @Override
        public void run() {
            // 在Run方法中，随机生成一个变量(线程要关联的数据)，然后以当前的线程名为key保存到map中去
            Integer i = random.nextInt(1000);
            // 获取当前线程名
            String name = Thread.currentThread().getName();
            // 将线程名和随机数放到map中
            //data.put(name, i);
            // 使用ThreadLocal存储key
            threadLocal.set(i);
            System.out.println("线程[" + name + "]生成的随机数是：" + i);

            // 让线程推迟执行
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            OrderService.createOrder();
            OrderDao.createOrder();

            //Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("线程[" + name + "]快要结束的时候取出随机数是：" + o);
        }

        public static void main(String[] args) {
            for (int i = 0; i < 3; i++) {
                new Thread(new Task()).start();
            }
        }
    }
}
