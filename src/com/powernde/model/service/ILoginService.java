package com.powernde.model.service;

import com.powernde.entity.ULogin;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.model.service
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/12 21:34
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public interface ILoginService {

ULogin getByPwdAndName(Integer name,String password);

    ULogin RegByULogin(ULogin uLogin);
}
