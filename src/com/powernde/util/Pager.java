package com.powernde.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * @ProjectName: ssm
 * @Package: com.bjpowernode.util
 * @Description: 翻页页
 * @Author: admin
 * @CreateDate: 2020/12/12 10:44
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class Pager {

    private int no = 1;//当前页号

    private int pageNo = 5;//每页记录数



    private int skipNo = 0;//起始行号(欲跳过的行数)

    private int totalRowCount = 0;//总记录数

    private int totalPageNo = 1;//总页号

    private String url;

    private boolean hasPrev = false;//是否有上一页

    private boolean hasNext = false;//是否有下一页

    public Pager(){

        //从当前本地线程当中获取请求
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        //获取当前的请求地址
        String uri = request.getRequestURI() + "?1=1";//http://localhost:8080/ssm/teacher/list?name=教&age=20.....

        /**
         * 获得请求当中所有的参数名称
         */
        Enumeration<String> parameterNames = request.getParameterNames();

        //迭代所有的 参数名称
        while(parameterNames.hasMoreElements()){

            //取出参数名称
            String paramName = parameterNames.nextElement();

            //根据参数名称获取参数的值
            String paramValue = request.getParameter(paramName);

            //如果参数的值不为空，并且参数不为常驻参数(1=1&no=?)，则拼接到当前请求地址的参数列表当中
            //
            if(paramValue != null && !"".equals(paramValue) && !"1".equals(paramName) && !"no".equals(paramName)){

                //对地址栏参数做转码
                try {
                    paramValue = URLEncoder.encode(paramValue,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                uri += "&" + paramName + "=" + paramValue;
            }

        }

        //为url属性赋值
        url = uri;
    }






    public void reCountSkipNo(){

        this.skipNo = (this.no - 1) * this.pageNo;

    }
    public void reCountTotalPageNo(){//总页数=总记录数/每页记录数

        //51 / 10
        this.totalPageNo = (int)Math.ceil(this.totalRowCount * 1.0 / this.pageNo);

        /*this.totalPageNo = this.totalRowCount  / this.pageNo;

        if(this.totalRowCount % this.pageNo > 0){

            this.totalPageNo ++;

        }*/

    }

    public void reCountHasPrev(){

        this.hasPrev = this.no != 1;

    }

    public void reCountHasNext(){

        this.hasNext = this.no != this.totalPageNo;

    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;

        //重新计算起始行号(欲跳过的行数)的值
        reCountSkipNo();
        //重新计算是否有上一页(首页)
        reCountHasPrev();
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;

        //重新计算起始行号(欲跳过的行数)的值
        reCountSkipNo();

    }

    public int getSkipNo() {
        return skipNo;
    }

    public void setSkipNo(int skipNo) {
        this.skipNo = skipNo;
    }


    public int getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(int totalRowCount) {
        this.totalRowCount = totalRowCount;

        //重新计算总页数
        reCountTotalPageNo();

        //重新计算是否有下一页（尾页）
        reCountHasNext();

    }

    public int getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(int totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public boolean getHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
