package com.atgugui.test;

import com.atgugui.dao.UserDaoImpl;
import com.atgugui.pojo.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;


/**
 * ClassName: UserDaoTest
 *
 * @Author: lichao
 * @Date: 2021/11/22
 * @Description:
 */
public class UserDaoTest {

    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User admin = userDao.queryUserByUsername("admin");
        if(admin == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名不可用！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        if (user == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        int i = userDao.saveUser(new User(null, "lichao", "lichao", "lichao@126.com"));
        if(i > 0) {
            System.out.println("注册成功");
        } else {
            System.out.println("注册失败");
        }

    }
}