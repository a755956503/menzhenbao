package cn.itcast.menzhen.regist;

import java.sql.Date;

/**
 * Created by Administrator on 2016/11/19.
 */

public class Regist {
    private int r_id;
    private String h_name;
    private String username;
    private int r_status;
    private String r_sex;
    private String r_sympton;
    private Date r_date;
    private String r_age;
    private String r_name;

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public int getR_status() {
        return r_status;
    }

    public void setR_status(int r_status) {
        this.r_status = r_status;
    }

    public String getR_sympton() {
        return r_sympton;
    }

    public void setR_sympton(String r_sympton) {
        this.r_sympton = r_sympton;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public String getR_age() {
        return r_age;
    }

    public void setR_age(String r_age) {
        this.r_age = r_age;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }
}
