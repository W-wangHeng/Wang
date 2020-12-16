package com.powernde.util;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.util
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/13 20:06
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class VerifyPwd {

    public boolean verifyPwd(String s1, String s2) {

        boolean flag = false;
        if (s1.equals(s2)) {
            //说明密码一样允许通过
            flag = true;
        }


        return flag;

    }
}
