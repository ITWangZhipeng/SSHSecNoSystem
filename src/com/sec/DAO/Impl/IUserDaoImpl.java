package com.sec.DAO.Impl;

import com.sec.DAO.IUserDao;
import com.sec.db.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * Created by 10433208 on 2016/12/9.
 */
public class IUserDaoImpl implements IUserDao {
    private IUserDaoImpl() {

    }

    public static IUserDaoImpl getInstance() {
        return new IUserDaoImpl();
    }

    @Override
    public void insert(User user) throws Exception {

    }

    @Override
    public void delUser(User user) throws Exception {

    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public List<User> queryAll() throws Exception {
        return null;
    }

    @Override
    public String queryById(int UserId) throws Exception {
        return null;
    }

    @Override
    public boolean loginValidate(User user) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        System.out.println("开始验证登录信息");
        Class cls = Class.forName("com.sec.test.LoginCheck");
        Method method = cls.getMethod("CheckLogin", User.class);
        System.out.println(method.getName());
        Object object = cls.newInstance();
        System.out.println(object.toString());
        try {
            Object result = method.invoke(object, user);
            System.out.println(result);
            return (Boolean) result;
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("此处接收被调用方法内部未被捕获的异常");
            Throwable t = e.getTargetException();// 获取目标异常
            t.printStackTrace();
            e.printStackTrace();

        }
        return false;

    }

}
