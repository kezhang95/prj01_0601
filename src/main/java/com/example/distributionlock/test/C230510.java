package com.example.distributionlock.test;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C230510
 * @Author: k.z
 * @CreateTime: 2023/5/10 10:35
 * @Description:
 */
public class C230510 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{});
        System.out.println("thread's state is "+t1.getState());
    }
}
