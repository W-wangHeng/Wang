<%--
  Created by IntelliJ IDEA.
  User: WangHeng
  Date: 2020/12/13
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登入注册界面</title>
</head>
<body>
<div>
    <h1 align="center">${LOGIN_USER.msg} ${LOGIN_USER.uCold} </h1>

    <form action="${pageContext.request.contextPath}/saveLogin">
        <table align="center" border="1px">
            <tr align="center" style="align-content: center">
                <td colspan="2">
                    <h1> 欢迎登入</h1><br>
                </td>
            </tr>
            <tr align="center" style="align-content: center">
                <td>账号：</td>
                <td>
                    <input type="text" name="uCold"/>
                </td>
            </tr>
            <tr align="center" style="align-content: center">
                <td>密码：</td>
                <td>
                    <input type="password" name="uPasswprd"/>
                </td>
            </tr>
            <tr align="center" style="align-content: center">
                <td colspan="2">
                    <input type="submit" value="登入"/>
                </td>
            </tr>

            <tr align="center" style="align-content: center">
                <td colspan="2">
                    <a href="${pageContext.request.contextPath}/register"> 用户注册 </a>
                </td>

            </tr>
        </table>
    </form>

</div>
</body>
</html>
