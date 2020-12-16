package com.powernde.model.service.impl;

import com.powernde.entity.Student;
import com.powernde.entity.Teacher;
import com.powernde.model.dao.StudentDao;

import com.powernde.model.dao.TeacherDao;
import com.powernde.model.service.IStudentService;
import com.powernde.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.model.service.impl
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/14 8:53
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class Studentservice implements IStudentService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    @Override
    public List<Student> list(Student student) {


        return studentDao.selectAll(student);
    }

    @Override
    public List<Student> list(Pager pager) {

        //查总记录数
        //int count = studentDao.searchTotalCount();

        //pager.setTotalRowCount(count);

        return studentDao.selectByPagers(pager);
    }

    @Override
    public List<Student> list(Student student, Pager pager) {

        //查总记录数
        int count = studentDao.searchTotalCount(student);

        pager.setTotalRowCount(count);

        return studentDao.selectByPager(student, pager);
    }

    @Override
    public void delete(Integer id) {
        studentDao.deleteByPrimaryKey(id);

    }

    //添加
    @Override
    public void saveInsert(Student student) {

        studentDao.insertSelective(student);

    }

    //修改
    @Override
    public void saveUpdate(Student student) {
        studentDao.updateByPrimaryKeySelective(student);
    }

    @Override
    public Student get(Integer stuId) {


        return studentDao.selectByPrimaryKey(stuId);
    }

    @Override
    public void delBatch(Integer[] tIds) {
        studentDao.deletebyEach(tIds);
    }

    @Override
    public List<Teacher> selectTea() {

        List<Teacher> list = teacherDao.selectAlll();


        return list;
    }
}
