package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import org.junit.Test;

/**
 * @ClassName JsonTest
 * @Description 用来学习json与JavaBean的转换
 * @Author 12468
 * @Date 2021/12/10 23:02
 * @Version 1.0
 */
public class JsonTest {

    private Gson gson = new Gson();

    /**
     * @Description: JavaBean转为json对象
     * @return: void
     * @Author: 12468
     * @Date: 2021/12/10 23:40
     */
    @Test
    public void test1() {
        Person person = new Person(1, "李超真帅");
        String personJsonString = gson.toJson(person);
        System.out.println("personJsonString = " + personJsonString);
    }
}
