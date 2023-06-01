package com.example.distributionlock.test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: RandomUtil
 * @Author: k.z
 * @CreateTime: 2023/3/2 23:07
 * @Description:
 */
public class RandomUtil {
    private static final int T_NUM = 0;

    public static void main(String[] args) throws Exception {
//        int ssr_count = 0;
//        int total_count = 1000000;
//        for (int a = 1;a<=total_count;a++){
//
//            int randomInt = getRandomInt();
//            if(randomInt>0){
//                ssr_count++;
//            }
//        }
//        System.out.println("成功次数为："+ssr_count);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> collect = integers.stream().filter(x -> x > 2).collect(Collectors.toList());
        System.out.println(collect);

    }

    private static int getRandomInt() throws NoSuchAlgorithmException {
        SecureRandom sha1PRNG = SecureRandom.getInstance("SHA1PRNG");
        int i = sha1PRNG.nextInt(100);
//        System.out.println("得到的随机整数为："+i);
        if (i == 1) {//1%
            return 1;
        } else if (i > 1 && i <= 21) {//20%
            return -1;
        } else if (i > 22 && i <= 52) {//30%
            return -2;
        } else if (i > 53 && i <= 93) {//40%
            return -3;
        } else {//9%
            return -4;
        }

    }
}
