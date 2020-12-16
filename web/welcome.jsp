<%--
  Created by IntelliJ IDEA.
  User: WangHeng
  Date: 2020/12/13
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登入界面</title>
</head>
<body>
<div>
    <table align="center" border="1px">
        <tr align="center" style="align-content: center">
            <td>
                <h1>欢迎${LOGIN_USER.uName}进入xxx系统</h1>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td>
                <a href="${pageContext.request.contextPath}/student/list">学生管理</a>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td>
                <a href="${pageContext.request.contextPath}/teacher/list">教师管理</a>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td>
                <a href="${pageContext.request.contextPath}/loginOut">退出系统</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
