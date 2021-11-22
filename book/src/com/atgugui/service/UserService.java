package com.atgugui.service;

import com.atgugui.pojo.User;

/**
 * ClassName: UserService
 *
 * @Author: lichao
 * @Date: 2021/11/22
 * @Description:
 */
public interface UserService {
    /**
    * Description: 注册用户<br/>
    * @author: 12468<br/>
    * @date: 2021/11/22 23:23<br/>
    * @param: User<br/>
    * @return:
    */
    public void registerUser(User user);

    /**
    * Description: 登录<br/>
    * @author: 12468<br/>
    * @date: 2021/11/22 23:24<br/>
    * @param: User<br/>
    * @return:
    */
    public User login(User user);

    /**
    * Description: 检查用户是否可用<br/>
    * @author: 12468<br/>
    * @date: 2021/11/22 23:25<br/>
    * @param: username<br/>
    * @return: 返回true表示已存在，返回false表示不可用
    */
    public boolean existUsername(String username);
}
