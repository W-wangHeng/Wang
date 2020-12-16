package com.powernde.model.dao;

import com.powernde.entity.ULogin;

public interface ULoginDao {
    int deleteByPrimaryKey(Integer uId);

    int insert(ULogin record);

    int insertSelective(ULogin record);

    ULogin selectByPrimaryKey(Integer uId);

    ULogin SelectByPwdAndName(Integer uCold,String password);

    int updateByPrimaryKeySelective(ULogin record);

    int updateByPrimaryKey(ULogin record);
}