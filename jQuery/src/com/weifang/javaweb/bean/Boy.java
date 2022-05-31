package com.weifang.javaweb.bean;

/**
 * @program:
 * @ClassName: Boy
 * @version: 1.0
 * @description: 男孩儿
 * @author: zhezhi
 * @create: 2022-05-31 16:38
 **/

public class Boy extends User{
    private String name;
    private String xxx;

    public Boy() {
        System.out.println("生了个男的");
    }

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.weifang.javaweb.bean.Boy");
            aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
