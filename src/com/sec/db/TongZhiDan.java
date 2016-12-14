package com.sec.db;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/11/30.
 */
@SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
@Entity
public class TongZhiDan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    @Basic
    @Column(name = "部门")
    private String department;

    @Basic
    @Column(name = "内容")
    private String content;


    @Basic
    @Column(name = "年度")
    private int year = Calendar.getInstance().get(Calendar.YEAR);


    public TongZhiDan() {
    }

    public TongZhiDan(String name, String content) {
        this.department = name;
        this.content = content;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setDepartment(String name) {
        this.department = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTid() {
        return tid;
    }

    public String getDepartment() {
        return department;
    }

    public String getContent() {
        return content;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String new_tid = String.format("%03d", tid);
        return department +
                (year - 2000) + '-' +
                new_tid +
                ':' + content ;
    }
}
