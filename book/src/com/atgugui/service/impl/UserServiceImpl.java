package com.atgugui.service.impl;

import com.atgugui.dao.UserDaoImpl;
import com.atgugui.pojo.User;
import com.atgugui.service.UserService;

/**
 * ClassName: UserServiceImpl
 *
 * @Author: lichao
 * @Date: 2021/11/22
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username) == null) {
            // 等于null说明没有查到，没查到表示可用
            return false;
        }
        return true;
    }
}
