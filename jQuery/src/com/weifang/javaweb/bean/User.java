package com.weifang.javaweb.bean;

/**
 * @program:
 * @ClassName: User
 * @version: 1.0
 * @description: 用户类
 * @author: zhezhi
 * @create: 2022-05-31 16:37
 **/

public class User {
    private String name;

    public User() {
        System.out.println("出生了");
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
