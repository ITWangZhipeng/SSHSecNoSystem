package com.sec.DAO;

import com.sec.db.User;

import java.util.List;

/**
 * Created by 10433208 on 2016/12/9.
 */
public interface IUserDao {
    //增
    void insert(User user) throws Exception;
    //删
    void delUser(User user) throws Exception;
    //改
    void updateUser(User user) throws Exception;
    //查全
    List<User> queryAll() throws Exception;
    //单查
    String queryById(int UserId) throws Exception;
    //验证登录
    boolean loginValidate(User user) throws  Exception;
}
