package com.powernde.util;

import com.powernde.entity.ULogin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.util
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/12 20:37
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ULogin login = (ULogin) request.getSession().getAttribute("LOGIN_USER");
        if (login == null) {

            response.sendRedirect(request.getContextPath() + "/login");

            return false;
        }

        return true;
    }


}
