package com.sec.DAO;

import com.sec.db.JiGui;

import java.util.List;

/**
 * Created by 10433208 on 2016/12/9.
 */
public interface IJiGuiDao {
    //增
    void insert(JiGui jigui) throws Exception;
    //删
    void delJiGui(JiGui jigui) throws Exception;
    //改
    void updateJiGui(JiGui jigui) throws Exception;
    //查全
    List<JiGui> queryAll() throws Exception;
    //单查
    String queryById(int JGId) throws Exception;
}
