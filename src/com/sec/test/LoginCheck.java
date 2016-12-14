package com.sec.test;

import com.sec.db.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public class LoginCheck {


    public LoginCheck() {

    }

    public boolean CheckLogin(User user) {
        Transaction transaction;
        Session session;
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        System.out.println("建立connection");
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String hql = "from User where userName =:username";
        Query query = session.createQuery(hql);
        System.out.println("用户名是：" + user.getUserName());
        query.setString("username", user.getUserName());
        List<User> list = query.list();
        try {
            for (User user1 : list) {
                System.out.println("查询出来的用户名" + user1.getUserName());
                if (user1.getPassword().equals(user.getPassword())) ;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
            sessionFactory.close();
        }
        return false;

    }
}
