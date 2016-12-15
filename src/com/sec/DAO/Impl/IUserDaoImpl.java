package com.sec.DAO.Impl;

import com.sec.DAO.IUserDao;
import com.sec.bean.myHibernateSessionFactory;
import com.sec.db.User;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.transaction.*;
import java.util.List;


/**
 * Created by 10433208 on 2016/12/9.
 */
public class IUserDaoImpl implements IUserDao {
    public IUserDaoImpl() {

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
    public boolean loginValidate(User user) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {
        System.out.println("开始验证登录信息");
//        Class cls = Class.forName("com.sec.test.LoginCheck");
//        Method method = cls.getMethod("CheckLogin", User.class);
//        System.out.println(method.getName());
//        Object object = cls.newInstance();
//        System.out.println(object.toString());
//        try {
//            Object result = method.invoke(object, user);
//            System.out.println(result);
//            return (Boolean) result;
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            System.out.println("此处接收被调用方法内部未被捕获的异常");
//            Throwable t = e.getTargetException();// 获取目标异常
//            t.printStackTrace();
//            e.printStackTrace();
//        }
        Transaction tx = null;
        String hql = "";
        try {
            Session session = myHibernateSessionFactory.getSessionFactory().getCurrentSession();
            tx = (Transaction) session.beginTransaction();
            hql = "from User where userName =:username";
            Query query = session.createQuery(hql);
            query.setString("username", user.getUserName());
            List list = query.list();
            tx.commit();
            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
    }

}
