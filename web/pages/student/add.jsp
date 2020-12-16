<%--
  Created by IntelliJ IDEA.
  User: WangHeng
  Date: 2020/12/14
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学习信息修改页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/saveUpdate" method="post">
    <table align="center" border="1px">
        <tr>
            <td align="center" colspan="2">
                <h2>
                    学生信息处理
                </h2>
            </td>
        </tr>
        <input type="hidden" name="stuId" value="${student.stuId}"/>
        <tr align="center" style="align-content: center">
            <td align="center">
                学生姓名：
            </td>
            <td align="center">
                <input type="text" name="stuName" value="${student.stuName}"/>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                学生性别：
            </td>
            <td align="center">
                <input type="radio" name="stuSix" value="男" ${student.stuSix eq "男"?"checked='checked'":""}/>男
                <input type="radio" name="stuSix" value="女" ${student.stuSix eq "女"?"checked='checked'":""}/>女
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                学生在校状态：
            </td>

            <td align="center">
                <select name="stuStatus">
                    <option value="在校" ${student.stuStatus eq "在校"?"selected='selected'":""}>在校</option>
                    <option value="离校" ${student.stuStatus eq "离校"?"selected='selected'":""}>离校</option>
                    <option value="休学" ${student.stuStatus eq "休学"?"selected='selected'":""}>休学</option>
                    <option value="毕业" ${student.stuStatus eq "毕业"?"selected='selected'":""}>毕业</option>
                </select>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                班主任：
            </td>

            <td align="center">

                <select name="teaId">
                    <c:forEach items="${teacher}" var="tea">
                        <option value="${tea.teaId}" ${student.teaId eq tea.teaId ?"selected='selected'":""}>${tea.teaName}</option>
                    </c:forEach>
                </select>

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
