package com.sec.db;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/11/30.
 */
@SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
@Entity
public class JiGui {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jid;

    /*@Basic
    @Column(name = "机规")
    private String department="机规";*/

    @Basic
    @Column(name = "内容")
    private String content;

    @Basic
    @Column(name = "年度")
    private int year = Calendar.getInstance().get(Calendar.YEAR);

    public JiGui() {
    }

    public JiGui(String content) {
        this.content = content;
    }

    public int getJid() {
        return jid;
    }


    public String getContent() {
        return content;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String new_sid = String.format("%03d", jid);
        return "机规" +
                (year - 2000) + '-' + new_sid +
                ":" + content ;
    }
}
