package com.powernde.model.service.impl;

import com.powernde.entity.Student;
import com.powernde.entity.Teacher;
import com.powernde.model.dao.StudentDao;
import com.powernde.model.dao.TeacherDao;
import com.powernde.model.service.ITeacherService;
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
public class TeacherService implements ITeacherService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    @Override
    public List<Teacher> list(Teacher teacher) {


        return teacherDao.selectAll(teacher);
    }

    @Override
    public List<Teacher> list(Pager pager) {

    /*    //查总记录数
        int count = teacherDao.searchTotalCount();

        pager.setTotalRowCount(count);*/

        return teacherDao.selectByPagers(pager);
    }

    @Override
    public List<Teacher> list(Teacher teacher, Pager pager) {

        //查总记录数
        int count = teacherDao.searchTotalCount(teacher);

        pager.setTotalRowCount(count);

        return teacherDao.selectByPager(teacher, pager);
    }

    @Override
    public void delete(Integer id) {
        teacherDao.deleteByPrimaryKey(id);

    }

    //添加
    @Override
    public void saveInsert(Teacher teacher) {

        teacherDao.insertSelective(teacher);

    }

    //修改
    @Override
    public void saveUpdate(Teacher teacher) {
        teacherDao.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public Teacher get(Integer teaId) {


        return teacherDao.selectByPrimaryKey(teaId);
    }

    @Override
    public void delBatch(Integer[] tIds) {

        teacherDao.deletebyEach(tIds);
    }

   /* @Override
    public List<Teacher> selectTea() {

        List<Teacher> list = teacherDao.selectAll();

        return list;
    }*/


}
