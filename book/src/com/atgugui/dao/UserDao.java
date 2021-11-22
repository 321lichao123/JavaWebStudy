package com.atgugui.dao;

import com.atgugui.pojo.User;

/**
 * ClassName: UserDao
 *
 * @Author: lichao
 * @Date: 2021/11/22
 * @Description:
 */
public interface UserDao {

    /**
    * Description: 根据用户姓名查询用户<br/>
    * @author: 12468<br/>
    * @date: 2021/11/22 22:52<br/>
    * @param:<br/>
    * @return: 如果返回null，表示没有这个用户，反之亦然
    */
    public User queryUserByUsername(String username);

    /**
    * Description: 根据用户姓名和密码查询用户<br/>
    * @author: 12468<br/>
    * @date: 2021/11/22 22:53<br/>
    * @param:<br/>
    * @return: 如果返回null，表示没有这个用户，反之亦然
    */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
    * Description: 保存注册的用户<br/>
    * @author: 12468<br/>
    * @date: 2021/11/22 22:54<br/>
    * @param:<br/>
    * @return:
    */
    public int saveUser(User user);
}
