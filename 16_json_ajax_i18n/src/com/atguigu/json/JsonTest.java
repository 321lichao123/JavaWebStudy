package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.*;

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
        // 使用toJson方法将Java对象转为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println("personJsonString = " + personJsonString);

        // fromJson把json字符串转回去Java对象
        // 第一个参数是json字符串 第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    /**
     * @Description: list和json的互转
     * @return: void
     * @Author: 12468
     * @Date: 2021/12/11 22:08
     */
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "刘晓芳"));
        personList.add(new Person(2, "李超"));

        String personListJsonString = gson.toJson(personList);
        System.out.println("personListJsonString = " + personListJsonString);

        List<Person> personList1 = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(personList1.toString());
        System.out.println(personList1.get(0));
    }

    /**
     * @Description: map和json的互转
     * @return: void
     * @Author: 12468
     * @Date: 2021/12/11 22:09
     */
    @Test
    public void test3() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person(1, "刘晓芳"));
        map.put(2, new Person(2, "李超"));
        String personMapToJson = gson.toJson(map);
        System.out.println(personMapToJson);

        //Map<Integer, Person> personMap1 = gson.fromJson(personMapToJson, new PersonMap().getType());
        Map<Integer, Person> personMap1 = gson.fromJson(personMapToJson, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println(personMap1);
        System.out.println(personMap1.get(1));
    }
}
