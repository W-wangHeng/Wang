package com.powernde.model.service;

import com.powernde.entity.Student;
import com.powernde.entity.Teacher;
import com.powernde.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.model.service
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/14 8:53
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface ITeacherService {

    List<Teacher> list(Teacher teacher);

    List<Teacher> list(Pager pager);

    List<Teacher> list( Teacher teacher,Pager pager);


    void delete(Integer id);

    void saveInsert(Teacher teacher);

    void saveUpdate(Teacher teacher);

    Teacher get(Integer teaId);

    void delBatch(Integer[] tIds);

}
