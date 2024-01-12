package com.example.distributionlock.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: ReBirth
 * @Author: k.z
 * @CreateTime: 2023/11/26 12:12
 * @Description:
 */
public class ReBirth {

    // 新的开始
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int a = 1;
        int b = 2;
        System.out.println("result is "+(a+b));
        int c = test(a,b);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = integers.stream().filter(x -> x > 2).collect(Collectors.toList());
        System.out.println("new result is"+collect);
        System.out.println("项目展开测试");
    }

    private static int test(int a, int b) {
        int x = b-a;
        int y = b*a;
        return y-x;
    }



}
