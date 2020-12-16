<%--
  Created by IntelliJ IDEA.
  User: WangHeng
  Date: 2020/12/13
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/saveRegister" method="post">
    <h1 align="center">${LOGIN_USER}</h1>
    <table align="center" border="1px">
        <tr align="center" style="align-content: center">
            <td colspan="2">
                <h1>用户注册</h1>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td>
                用户名：
            </td>
            <td>
                <input type="text" name="uName"/>
            </td>

        </tr>

        <tr align="center" style="align-content: center">
            <td>
                密码：
            </td>
            <td>
                <input type="password" name="uPasswprd">
            </td>
        </tr>

        <tr align="center" style="align-content: center">
            <td>
                确认密码：
            </td>
            <td>
                <input type="password" name="reuPasswprd">
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td>
                邮箱：
            </td>
            <td>
                <input type="text" name="uEmail">
            </td>
        </tr>
        <tr align="center" style="align-content: center">

            <td colspan="2">
                <input type="submit" value="注册">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
