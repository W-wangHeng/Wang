package com.powernde.controller;

import com.powernde.entity.Student;

import com.powernde.entity.Teacher;
import com.powernde.model.service.IStudentService;
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
 * @CreateDate: 2020/12/14 8:56
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("student")
public class StudentConteroller {

    @Autowired
    IStudentService studentService;

    /*@RequestMapping("list")
    List<Student> list(Student student) {


        //        //return teacherService.list();

        // return teacherService.list(teacher);


        List<Student> list = studentService.list(student);
        return list;
    }*/


    @RequestMapping("list")
    List<Student> list(Student student, Pager pager, HttpSession session) {

        Integer teaId = (Integer) session.getAttribute("teaId");

        if (teaId != null) {
            student.setTeaId(teaId);
        }




        //        //return teacherService.list();

        // return teacherService.list(teacher);
        List<Teacher> lists = studentService.selectTea();
        session.setAttribute("teacher", lists);

        List<Student> list = studentService.list(student, pager);
        return list;
    }

    @RequestMapping("delete")
    String delete(Integer stuId) {

        studentService.delete(stuId);
        return "redirect:list";
    }

    //添加
    @RequestMapping("edit")
    /*void edit(Integer teaId, HttpSession session) {


        new Student().setTeaId(teaId);
    }*/
    Student edit(Integer teaId) {
        Student student = new Student();
        student.setTeaId(teaId);
        return student;
    }

    @RequestMapping("saveInsert")
    String saveInsert(Student student) {

        studentService.saveInsert(student);
        return "redirect:list";
    }

    //修改
    @RequestMapping("add")
    Student add(Integer stuId) {


        return studentService.get(stuId);
    }

    @RequestMapping("saveUpdate")
    String saveUpdate(Student student) {


        studentService.saveUpdate(student);

        return "redirect:list";
    }

    @RequestMapping("delBatch")
    String delBatch(Integer[] tIds) {
        studentService.delBatch(tIds);
        return "redirect:list";
    }


}
