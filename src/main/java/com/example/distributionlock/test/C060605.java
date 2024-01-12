package com.example.distributionlock.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C060605
 * @Author: k.z
 * @CreateTime: 2023/6/6 1:00
 * @Description:
 */
public class C060605 implements Runnable{
    public static void main(String[] args) throws ExecutionException,InterruptedException {

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu当前的可用线程数为"+i);
        if(i>0){//存在可用线程数
            ExecutorService executorService = Executors.newFixedThreadPool(i);
            executorService.execute(new C060605());
        }
        // 手动创建线程池


    }

    @Override
    public void run() {
        System.out.println("采用线程池的方式创建线程执行任务");
    }
}
