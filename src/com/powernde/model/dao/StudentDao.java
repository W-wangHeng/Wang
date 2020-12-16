package com.powernde.model.dao;

import com.powernde.entity.Student;
import com.powernde.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


    List<Student> selectAll(Student student);

    List<Student> selectByPagers(Pager pager);

    void deletebyEach(Integer[] tIds);

    int searchTotalCount(Student student);

    List<Student> selectByPager(@Param("student") Student student, @Param("pager") Pager pager);
}