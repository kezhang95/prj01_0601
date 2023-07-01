package com.example.distributionlock.test;

import java.util.Objects;

/**
 * @Package: com.example.distributionlock.test
 * @ClassName: User
 * @Author: k.z
 * @CreateTime: 2023/6/6 11:09
 * @Description:
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        // 这是我测试的方法
        System.out.println("hello world");
        User user = (User) o;
        return user.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
