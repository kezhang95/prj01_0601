package com.example.distributionlock.test;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C060602
 * @Author: k.z
 * @CreateTime: 2023/6/6 0:40
 * @Description: 采用实现runnable接口，重写run方法
 */
public class C060602 implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new C060602());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("runnable创建线程所执行的方法");
    }
}
