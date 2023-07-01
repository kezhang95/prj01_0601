package com.example.distributionlock.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C060604
 * @Author: k.z
 * @CreateTime: 2023/6/6 0:47
 * @Description:
 */
public class C060604 implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new C060604());
        Thread thread = new Thread(futureTask);
        thread.start();
        Object o = futureTask.get();
        System.out.println(o);
    }

    @Override
    public Object call() throws Exception {
        return "返回结果";
    }
}
