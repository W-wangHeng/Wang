<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WangHeng
  Date: 2020/12/14
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息添加界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/saveInsert" method="post">
    <table align="center" border="1px">
        <tr>
            <td align="center" colspan="2">
                <h2>
                    学生信息处理
                </h2>
            </td>
        </tr>

        <tr align="center" style="align-content: center">
            <td align="center">
                学生姓名：
            </td>
            <td align="center">
                <input type="text" name="stuName"/>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                学生性别：
            </td>
            <td align="center">
                <input type="radio" name="stuSix" value="男"/>男
                <input type="radio" name="stuSix" value="女"/>女
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                学生在校状态：
            </td>

            <td align="center">
                <select name="stuStatus">
                    <option value="在校">在校</option>
                    <option value="离校">离校</option>
                    <option value="休学">休学</option>
                    <option value="毕业">毕业</option>
                </select>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                班主任：
            </td>

            <td align="center">


                <select name="teaId">
                    <option value="">请选择学生班主任</option>
                    <c:forEach items="${teacher}" var="tea">
                        <option value="${tea.teaId}" ${student.teaId eq tea.teaId ?"selected='selected'":""}>${tea.teaName}</option>
                    </c:forEach>
                    <%-- <option value="1" ${student.teaId eq "1"?"selected='selected'":""}>王老师</option>
                     <option value="2" ${student.teaId eq "2"?"selected='selected'":""}>李老师</option>
                     <option value="3" ${student.teaId eq "3"?"selected='selected'":""}>张老师</option>
                     <option value="4" ${student.teaId eq "4"?"selected='selected'":""}>程老师</option>--%>
                </select>
                <%--<select name="teaId">
                    <option value="1">王老师</option>
                    <option value="2">李老师</option>
                    <option value="3">张老师</option>
                    <option value="4">程老师</option>
                </select>--%>

            </td>

        </tr>
        <tr align="center" style="align-content: center">
            <td align="center" colspan="2">
                <input type="submit" value="确认"/>
            </td>
        </tr>
    </table>

</form>

</body>
</html>
