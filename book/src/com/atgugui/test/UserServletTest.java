package com.atgugui.test;

import java.lang.reflect.Method;

/**
 * ClassName: UserServletTest
 *
 * @Author: lichao
 * @Date: 2021/11/29
 * @Description:
 */
public class UserServletTest {
    public static void main(String[] args) {
        String action = "register";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() {
        System.out.println("调用login方法");
    }

    public void register() {
        System.out.println("调用register方法");
    }

    public void updateUser() {
        System.out.println("调用update User方法");
    }

    public void updateUserPassword() {
        System.out.println("调用updateUserPassword方法");
    }
}
