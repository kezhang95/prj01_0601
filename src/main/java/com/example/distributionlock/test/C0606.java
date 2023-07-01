package com.example.distributionlock.test;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C0606
 * @Author: k.z
 * @CreateTime: 2023/6/6 0:37
 * @Description: 采用集成Thread类，重写run方法
 */
public class C0606 extends Thread{

    public static void main(String[] args) {
        C0606 thread = new C0606();
        thread.start();
    }

    @Override
    public void run() {
        super.run();
        System.out.println("线程中执行的方法");
    }
}
