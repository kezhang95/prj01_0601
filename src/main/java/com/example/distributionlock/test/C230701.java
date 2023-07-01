package com.example.distributionlock.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: C230701
 * @Author: k.z
 * @CreateTime: 2023/7/1 16:17
 * @Description:
 */
public class C230701 {
    public static void main(String[] args) {
        boolean flag = true;
        int programCount = 0;
        while (flag) {
            List redResult = extracted(1, 33, "red");
            List blueResult = extracted(1, 16, "blue");
            if (redResult.size() < 6 || blueResult.size() < 1) {
                programCount++;
            } else {
                Collections.sort(redResult);
                Collections.sort(blueResult);
                System.out.println("红球开奖结果为：" + redResult);
                System.out.println("蓝球开奖结果为：" + blueResult);
                flag = false;
            }
            if(programCount>99){
                flag = false;
            }


        }


    }

    // 判断是否合法
    private static List extracted(int min, int max, String color) {
        List collect = new ArrayList();
        switch (color) {
            case "red":
                collect = getList(min, max, 6);
                if (collect.size() < 6) {
                    collect.clear();
                    collect = getList(min, max, 6);
                }
                break;
            case "blue":
                collect = getList(min, max, 1);
                if (collect.size() < 1) {
                    collect.clear();
                    collect = getList(min, max, 1);
                }
                break;
            default:
                throw new RuntimeException("只能产生红球或蓝球结果");
        }

        return collect;

    }

    // 产生数组
    private static List getList(int min, int max, int count) {
        List intList = new ArrayList();
        for (int i = 0; i < count; i++) {
            intList.add(getRandomNumberInRange(min, max));
        }
        List collect = (List) intList.stream().distinct().collect(Collectors.toList());
        return collect;
    }

    // 产生随机数
    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;

    }
}
