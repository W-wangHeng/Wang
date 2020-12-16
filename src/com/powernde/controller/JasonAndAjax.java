package com.powernde.controller;


import com.alibaba.fastjson.JSONObject;

import com.powernde.entity.Teacher;


import com.powernde.model.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.controller
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/16 11:13
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

@Controller
public class JasonAndAjax {


    @Autowired
    private ITeacherService iTeacherService;


    @RequestMapping("")
    void objectTest01(HttpServletResponse response) {
        Teacher teacher = new Teacher();
        List<Teacher> list = iTeacherService.list(teacher);

        String string = JSONObject.toJSONString(list);


    }
}
