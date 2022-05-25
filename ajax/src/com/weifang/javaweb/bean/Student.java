package com.weifang.javaweb.bean;

import java.io.Serializable;

/**
 * @program:
 * @ClassName: Student
 * @version: 1.0
 * @description: 学生类
 * @author: zhezhi
 * @create: 2022-05-25 15:12
 **/
public class Student implements Serializable {
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
