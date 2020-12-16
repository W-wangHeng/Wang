package com.powernde.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_teacher
 *
 * @author
 */
public class Teacher implements Serializable {
    /**
     * 老师自增id
     */
    private Integer teaId;

    /**
     * 老师姓名
     */
    private String teaName;

    /**
     * 老师年龄
     */
    private String teaAge;
    /**
     * 老师年龄范围起始年龄
     */
    private String teaStartAge;

    /**
     * 老师年龄范围至年龄
     */
    private String teaEndAge;

    /**
     * 老师性别
     */
    private String teaSex;

    /**
     * 老师入职日期
     */
    private String teaDate;
    /**
     * 老师入职日期起始值
     */
    private String teaStartDate;
    /**
     * 老师入职日期结束值
     */
    private String teaEndDate;

    private static final long serialVersionUID = 1L;

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(String teaAge) {
        this.teaAge = teaAge;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public String getTeaDate() {
        return teaDate;
    }

    public void setTeaDate(String teaDate) {
        this.teaDate = teaDate;
    }

    public String getTeaStartDate() {
        return teaStartDate;
    }

    public void setTeaStartDate(String teaStartDate) {
        this.teaStartDate = teaStartDate;
    }

    public String getTeaEndDate() {
        return teaEndDate;
    }

    public void setTeaEndDate(String teaEndDate) {
        this.teaEndDate = teaEndDate;
    }
    public String getTeaStartAge() {
        return teaStartAge;
    }

    public void setTeaStartAge(String teaStartAge) {
        this.teaStartAge = teaStartAge;
    }

    public String getTeaEndAge() {
        return teaEndAge;
    }

    public void setTeaEndAge(String teaEndAge) {
        this.teaEndAge = teaEndAge;
    }
}