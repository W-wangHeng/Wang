package com.powernde.entity;

import java.io.Serializable;

/**
 * t_student
 *
 * @author
 */
public class Student implements Serializable {
    /**
     * 学生自增id
     */
    private Integer stuId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生性别
     */
    private String stuSix;

    /**
     * 学生在校状态
     */
    private String stuStatus;

    /**
     * 对应班主任主键
     */
    private Integer teaId;

    /**
     * 教师
     */
    private Teacher teacher;


    private static final long serialVersionUID = 1L;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSix() {
        return stuSix;
    }

    public void setStuSix(String stuSix) {
        this.stuSix = stuSix;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }


    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuSix='" + stuSix + '\'' +
                ", stuStatus='" + stuStatus + '\'' +
                ", teaId=" + teaId +
                '}';
    }
}