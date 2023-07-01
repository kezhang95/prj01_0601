package com.example.distributionlock.test;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: SynchronizedDemo
 * @Author: k.z
 * @CreateTime: 2023/6/6 1:34
 * @Description:
 */
public class SynchronizedDemo {


    public void func(){
        synchronized (this){
            System.out.println("func start...");
        }
    }
}
