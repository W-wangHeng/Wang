package com.powernde.model.service;

import com.powernde.entity.Student;
import com.powernde.entity.Teacher;
import com.powernde.util.Pager;

import java.util.List;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.model.service
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/14 8:52
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface IStudentService {
    List<Student> list(Student student);

    List<Student> list(Pager pager);

    List<Student> list(Student student, Pager pager);


    void delete(Integer id);

    void saveInsert(Student student);

    void saveUpdate(Student student);

    Student get(Integer stuId);

    void delBatch(Integer[] tIds);

    List<Teacher> selectTea();
}
