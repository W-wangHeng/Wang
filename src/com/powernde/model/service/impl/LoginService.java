package com.powernde.model.service.impl;

import com.powernde.entity.ULogin;
import com.powernde.model.dao.ULoginDao;
import com.powernde.model.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.model.service.impl
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/12 21:34
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class LoginService implements ILoginService {


    @Autowired
    private ULoginDao uLoginDao;

    //用户登入验证
    @Override
    public ULogin getByPwdAndName(Integer name, String password) {
        ULogin uLogin = uLoginDao.SelectByPwdAndName(name, password);

        return uLogin;
    }

    //用户注册信息
    @Override
    public ULogin RegByULogin(ULogin uLogin) {

        int i = uLoginDao.insertSelective(uLogin);
        ULogin login = uLoginDao.SelectByPwdAndName(uLogin.getuCold(), uLogin.getuPasswprd());
        return login;
    }
}
