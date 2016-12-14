package com.sec.test;


import com.sec.db.ChuanZhen;
import com.sec.db.JiGui;
import com.sec.db.TongZhiDan;
import com.sec.db.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBTest {
    Session session;
    Transaction transaction;
    Configuration configuration = new Configuration().configure();
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
            .buildServiceRegistry();
    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    @Before
    public void start() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void end() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void Test() {
        User user1 = new User(10433208, "王志鹏", "111111");
        User user2 = new User(10433234, "秦小伟", "111111");
        User user3 = new User(10433207, "李兆辉", "111111");
        User user4 = new User(10432414, "陈福龙", "111111");

        Set<TongZhiDan> tongZhiDanSet = new HashSet<TongZhiDan>();
        TongZhiDan tongZhiDan1 = new TongZhiDan("设订单", "NOB10000SH30C065......");
        TongZhiDan tongZhiDan2 = new TongZhiDan("设订单", "NOB10000SH30C066......");
        TongZhiDan tongZhiDan3 = new TongZhiDan("设订单", "NOB10000SH30C067......");

        tongZhiDanSet.add(tongZhiDan1);
        tongZhiDanSet.add(tongZhiDan2);
        tongZhiDanSet.add(tongZhiDan3);
        user1.setTongZhiDens(tongZhiDanSet);

        session.save(tongZhiDan1);
        session.save(tongZhiDan2);
        session.save(tongZhiDan3);


        Set<JiGui> jiGuiSet = new HashSet<JiGui>();
        JiGui jiGui1 = new JiGui("NOB0600SH30C021...");
        JiGui jiGui2 = new JiGui("NOB0600SH30C022...");
        JiGui jiGui3 = new JiGui("NOB0600SH30C023...");

        jiGuiSet.add(jiGui1);
        jiGuiSet.add(jiGui2);
        jiGuiSet.add(jiGui3);
        user1.setJiGuis(jiGuiSet);

        session.save(jiGui1);
        session.save(jiGui2);
        session.save(jiGui3);

        Set<ChuanZhen> chuanZhenSet = new HashSet<ChuanZhen>();
        ChuanZhen chuanZhen1 = new ChuanZhen("NOB0600SH30C021...");
        ChuanZhen chuanZhen2 = new ChuanZhen("NOB0600SH30C021...");
        ChuanZhen chuanZhen3 = new ChuanZhen("NOB0600SH30C021...");

        chuanZhenSet.add(chuanZhen1);
        chuanZhenSet.add(chuanZhen2);
        chuanZhenSet.add(chuanZhen3);
        user1.setChuanZhens(chuanZhenSet);

        session.save(chuanZhen1);
        session.save(chuanZhen2);
        session.save(chuanZhen3);

        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);

    }

    @Test
    public void Inquiry_TZD() {
        Long WorkID = 10433208L;
        String hql = "from TongZhiDan where WorkID =:WorkID";
        Query query = session.createQuery(hql);
        query.setLong("WorkID", WorkID);
        List<TongZhiDan> list = query.list();
        for (TongZhiDan TZD : list) {
            System.out.println(TZD.toString());
        }
    }

    @Test
    public void Inquiry_JG() {
        Long WorkID = 10433208L;
        String hql = "from JiGui where WorkID =:WorkID";
        Query query = session.createQuery(hql);
        query.setLong("WorkID", WorkID);
        List<JiGui> list = query.list();
        for (JiGui JG : list) {
            System.out.println(JG.toString());
        }
    }

    @Test
    public void Inquiry_CZ() {
        Long WorkID = 10433208L;
        String hql = "from ChuanZhen where WorkID =:WorkID";
        Query query = session.createQuery(hql);
        query.setLong("WorkID", WorkID);
        List<ChuanZhen> list = query.list();
        for (ChuanZhen CZ : list) {
            System.out.println(CZ.toString());
        }
    }

    @Test
    public void checklogin() {
        User user = new User();
        user.setUserName("王志鹏");
        user.setPassword("111111");
        String hql = "from User where userName =:username";
        Query query = session.createQuery(hql);
        System.out.println("用户名是：" + user.getUserName());
        query.setString("username", user.getUserName());
        List<User> list = query.list();
        for (User user1 : list) {
            System.out.println("查询出来的用户名" + user1.getUserName());
            if (user1.getPassword().equals(user.getPassword())) ;
            System.out.println("登陆成功");

        }
        System.out.println("登录失败");

    }
}



