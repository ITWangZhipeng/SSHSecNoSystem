package com.sec.DAO;

import com.sec.db.TongZhiDan;

import java.util.List;

/**
 * Created by 10433208 on 2016/12/9.
 */
public interface ITongZhiDanDao {
    //增
    void insert(TongZhiDan tongZhiDan) throws Exception;
    //删
    void delTongZhiDan(TongZhiDan tongZhiDan) throws Exception;
    //改
    void updateTongZhiDan(TongZhiDan tongZhiDan) throws Exception;
    //查全
    List<TongZhiDan> queryAll() throws Exception;
    //单查
    String queryById(int TZDId) throws Exception;
}
