package com.powernde.util;

import com.powernde.entity.ULogin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.util
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/15 18:56
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        //1,doFilter 方法的第一个参数为ServletRequest对象。此对象给过滤器提供了对进入的信息（包括表单数据、cookie和HTTP请求头）的完全访问。
        //第二个参数为ServletResponse，通常在简单的过滤器中忽略此参数。最后一个参数为FilterChain，此参数用来调用servlet或 JSP页。
        servletResponse.setCharacterEncoding("utf-8");//解决response重定向到主页后出现的中文乱码；
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中无法得到的方法，
        //就要把此request对象构造成HttpServletRequest
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String currentURL = request.getRequestURI();//取得根目录所对应的绝对路径:
        String targetURL = currentURL.substring(currentURL.indexOf("/", 1), currentURL.length());//截取到当前文件名用于比较
        //HttpServletRequest.getSession(false) 等同于： 若当前存在Session则返回该会话，否则返回NULL，因此，一般情况下，尽量要明确使用参数为false的写法。
        HttpSession session = request.getSession(false);
        PrintWriter pw = response.getWriter();
        //首先判断是否当前界面是否为登录界面；
        if (!"/pages/login.jsp".equals(targetURL)) {
            //判断当前页是否是重定向以后的登录页面页面，如果是就不做session的判断，防止出现死循环

            if (session == null || session.getAttribute("LOGIN_USER") == null) {
                //*用户登录以后需手动添加session
                pw.write("<script>alert('您还没有登录!');</script>");
                //System.out.println("request.getContextPath()=" + request.getContextPath());
                response.sendRedirect(request.getContextPath() + "/login");//如果session为空表示用户没有登录就重定向到login.jsp页面
                return;

            } else {
                response.sendRedirect(request.getContextPath() + "/index");
            }
        }
        //加入filter链继续向下执行
        //调用FilterChain对象的doFilter方法。Filter接口的doFilter方法取一个FilterChain对象作为它的一个参数。
        //在调用此对象的doFilter方法时，激活下一个相关的过滤器。如果没有另一个过滤器与servlet或JSP页面关联，则servlet或JSP页面被激活。
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
