package com.atgugui.test;

import com.atgugui.pojo.User;
import com.atgugui.service.impl.UserServiceImpl;
import org.junit.Test;


/**
 * ClassName: UserServiceTest
 *
 * @Author: lichao
 * @Date: 2021/11/22
 * @Description:
 */
public class UserServiceTest {
    private UserServiceImpl userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User("刘小芳", "lxf123", "lxf@126.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User("lichao", "lichao", null));
        if(user == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existUsername() {
        boolean username = userService.existUsername("刘小芳");
        if (username) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}