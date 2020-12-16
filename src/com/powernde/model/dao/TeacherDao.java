package com.powernde.model.dao;

import com.powernde.entity.Teacher;
import com.powernde.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    int deleteByPrimaryKey(Integer teaId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teaId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> selectAll(Teacher teacher);



    int searchTotalCount(Teacher teacher);

    List<Teacher> selectByPager(@Param("teacher") Teacher teacher, @Param("pager")Pager pager);

    void deletebyEach(Integer[] tIds);

    List<Teacher> selectByPagers(Pager pager);

    List<Teacher> selectAlll();
}