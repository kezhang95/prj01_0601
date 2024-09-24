package com.example.distributionlock.test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: ReBirth2
 * @Author: k.z
 * @CreateTime: 2024/1/12 14:28
 * @Description:
 */
public class ReBirth2 {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.withDayOfMonth(now.lengthOfMonth());
        if(now== localDate){
            System.out.println("执行对应操作");
        }

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers);

        System.out.println("Hello World!");

    }
}
