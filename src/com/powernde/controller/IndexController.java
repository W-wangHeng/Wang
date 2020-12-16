package com.powernde.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.controller
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/13 10:22
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    ModelAndView index(HttpSession session) {


        session.removeAttribute("teaId");


        ModelAndView modelAndView = new ModelAndView();

        //可以调用Service
        modelAndView.setView(new InternalResourceView("/welcome.jsp"));

        return modelAndView;

    }
}
