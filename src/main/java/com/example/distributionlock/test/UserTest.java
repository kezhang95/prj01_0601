package com.example.distributionlock.test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: UserTest
 * @Author: k.z
 * @CreateTime: 2023/6/6 11:39
 * @Description:
 */
public class UserTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(new User("zk"),"001");
        System.out.println("验证是否相等"+map.get(new User("zk")));

        StringJoiner sj = new StringJoiner(",","<",">");
        sj.add("张三");
        sj.add("李四");
        sj.add("王五");
        System.out.println(sj.toString());

    }
}
