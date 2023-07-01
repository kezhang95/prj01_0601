package com.example.distributionlock.test;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C060603
 * @Author: k.z
 * @CreateTime: 2023/6/6 0:43
 * @Description:
 */
public class C060603 {

    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("采用匿名内部类执行线程中任务");
//            }
//        });
//        thread.start();
        // java 8 支持以lamda表达式来实现上述方法
        Thread thread = new Thread(()-> System.out.println("lamda采用匿名内部类执行线程中任务"));
        thread.start();
    }

}
