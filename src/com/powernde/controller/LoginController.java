package com.powernde.controller;

import com.powernde.entity.ULogin;
import com.powernde.model.service.ILoginService;
import com.powernde.util.Random;
import com.powernde.util.VerifyPwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.controller
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/12 21:44
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping("login")
    void login() {

    }

    @RequestMapping("saveLogin")
    String saveLogin(ULogin uLogin, HttpSession session) {
        ULogin uLoginDB = loginService.getByPwdAndName(uLogin.getuCold(), uLogin.getuPasswprd());
        if (uLoginDB == null) {
            uLogin.setMsg("请检查账户或者密码是否正确");
            return "login";
        }
        session.setAttribute("LOGIN_USER", uLoginDB);

        return "redirect:/";
    }

    @RequestMapping("loginOut")
    String loginOut(HttpSession session) {

        session.removeAttribute("LOGIN_USER");


        return "login";
    }

    @RequestMapping("register")
    void register() {


    }

    @RequestMapping("saveRegister")
    String saveRegister(ULogin uLogin, HttpSession session) {
        String s = uLogin.getuPasswprd();
        String reuPasswprd = uLogin.getReuPasswprd();
        VerifyPwd verifyPwd = new VerifyPwd();
        boolean b = verifyPwd.verifyPwd(s, reuPasswprd);

        if (b) {
            //随机生成十位数
            uLogin.setuCold(new Random().randomNum());

            ULogin login = loginService.RegByULogin(uLogin);
            if (login != null) {
                login.setMsg("你的账号是：");
                session.setAttribute("LOGIN_USER", login);
                return "login";
            } else {

                return "register";
            }

        } else {
            session.setAttribute("LOGIN_USER", "你两次输入的密码不一致，请重新注册");
            return "register";
        }


    }


}
