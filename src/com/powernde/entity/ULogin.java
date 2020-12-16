package com.powernde.entity;

import java.io.Serializable;

/**
 * u_login
 *
 * @author
 */
public class ULogin implements Serializable {
    /**
     * 用户id主键id
     */
    private Integer uId;

    /**
     * 用户姓名
     */
    private String uName;

    /**
     * 用户密码
     */
    private String uPasswprd;

    /**
     * 用户账号
     */
    private Integer uCold;

    /**
     * 用户注册邮箱
     */
    private String uEmail;

    /**
     * 自定义信息反馈
     */
    private String msg;


    /**
     * 自定义确认密码
     */
    private String reuPasswprd;


    public String getReuPasswprd() {
        return reuPasswprd;
    }

    public void setReuPasswprd(String reuPasswprd) {
        this.reuPasswprd = reuPasswprd;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPasswprd() {
        return uPasswprd;
    }

    public void setuPasswprd(String uPasswprd) {
        this.uPasswprd = uPasswprd;
    }

    public Integer getuCold() {
        return uCold;
    }

    public void setuCold(Integer uCold) {
        this.uCold = uCold;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
}