package com.sec.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/30.
 */
@SuppressWarnings({"JpaDataSourceORMInspection", "unused", "SpellCheckingInspection"})
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "WorkId")
    @GenericGenerator(name = "WorkId", strategy = "assigned")
    private long WorkID;

    @Basic
    @Column(name = "userName")
    private String userName;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkID")
    private Set<TongZhiDan> tongZhiDens;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkID")
    private Set<JiGui> jiGuis;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkID")
    private Set<ChuanZhen> chuanZhens;

    @Basic
    private String password;

    public User() {
    }

    public User(long workID, String userName, String pwd) {
        WorkID = workID;
        this.userName = userName;
        this.password = pwd;
    }


    public long getWorkID() {
        return WorkID;
    }

    public String getUserName() {
        return userName;
    }


    public void setWorkID(long workID) {
        WorkID = workID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<TongZhiDan> getTongZhiDens() {
        return tongZhiDens;
    }

    public Set<JiGui> getJiGuis() {
        return jiGuis;
    }

    public Set<ChuanZhen> getChuanZhens() {
        return chuanZhens;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTongZhiDens(Set<TongZhiDan> tongZhiDens) {
        this.tongZhiDens = tongZhiDens;
    }

    public void setJiGuis(Set<JiGui> jiGuis) {
        this.jiGuis = jiGuis;
    }

    public void setChuanZhens(Set<ChuanZhen> chuanZhens) {
        this.chuanZhens = chuanZhens;
    }

    @Override
    public String toString() {
        return "com.sec.db.User{" +
                " 工号='" + WorkID + '\'' +
                ", 用户名='" + userName + '\'' +
                ", 密码='" + password + '\'' +
                '}';
    }

}
