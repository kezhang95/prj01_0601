package com.example.distributionlock.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C230510
 * @Author: k.z
 * @CreateTime: 2023/5/10 10:35
 * @Description:
 */
public class C230510 {
    public static void main(String[] args) {
//        Thread t1 = new Thread(()->{});
//        System.out.println("thread's state is "+t1.getState());
//        System.out.println("修改了一行");

        List<String> strings = Arrays.asList("1", "2", "3");
        List<String> collect = strings.stream().filter(x -> "1".equals(x)).collect(Collectors.toList());
        System.out.println(collect);
        int x = 1;
        int y = 2;
        // test if
        switch(x){
            case 1:
                y = 3;
                break;
            case 2:
                y = 4;
                break;
            default:
                y = 5;
                break;
        }
        System.out.println(y);
    }
}
