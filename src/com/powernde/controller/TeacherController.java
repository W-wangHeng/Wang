package com.powernde.controller;

import com.powernde.entity.Student;
import com.powernde.entity.Teacher;

import com.powernde.model.service.ITeacherService;
import com.powernde.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.controller
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/15 11:10
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    ITeacherService teacherService;

    @RequestMapping("list")
    List<Teacher> list(Teacher teacher, Pager pager, HttpSession session) {
        Teacher teacher1 = (Teacher) session.getAttribute("teacherss");

        if (teacher1 != null) {
            teacher = teacher1;
            session.removeAttribute("teacherss");
        }
        session.removeAttribute("teaId");

        //        //return teacherService.list();

        // return teacherService.list(teacher);
      /*  List<Teacher> lists = teacherDao.selectTea();
        session.setAttribute("teacher", lists);*/

        List<Teacher> list = teacherService.list(teacher, pager);
        return list;
    }

    @RequestMapping("delete")
    String delete(Integer teaId) {

        teacherService.delete(teaId);
        return "redirect:list";
    }

    //添加
    @RequestMapping("edit")
    void edit() {


    }

    @RequestMapping("saveInsert")
    String saveInsert(Teacher teacher) {

        teacherService.saveInsert(teacher);
        return "redirect:list";
    }

    //修改
    @RequestMapping("add")
    Teacher add(Integer teaId) {


        return teacherService.get(teaId);
    }

    @RequestMapping("saveUpdate")
    String saveUpdate(Teacher teacher, HttpSession session) {

        session.setAttribute("teacherss", teacher);


        teacherService.saveUpdate(teacher);

        return "redirect:list";
    }

    @RequestMapping("delBatch")
    String delBatch(Integer[] tIds) {
        teacherService.delBatch(tIds);
        return "redirect:list";
    }


    @RequestMapping("selectStudent")
    String selectStudent(Integer teaId, HttpSession session) {
        session.setAttribute("teaId", teaId);

        return "redirect:" + "/student/list";
    }

}
