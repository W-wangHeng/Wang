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

    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/js/datePicker/WdatePicker.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/teacher/saveUpdate" method="post">
    <input type="hidden" name="teaId" value="${teacher.teaId}"/>
    <table align="center" border="1px">
        <tr>
            <td align="center" colspan="2">
                <h2>
                    教师信息处理
                </h2>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                教师姓名：
            </td>
            <td align="center">
                <input type="text" name="teaName" value="${teacher.teaName}"/>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                教师性别：
            </td>
            <td align="center">
                <input type="radio" name="teaSex" value="男" ${teacher.teaSex eq "男" ? "checked='checked'":""}/>男
                <input type="radio" name="teaSex" value="女" ${teacher.teaSex eq "女" ? "checked='checked'":""}/>女
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                教师年龄：

            </td>

            <td align="center">
                <select name="teaAge">
                    <c:forEach var="i" begin="1" end="99">
                        <option value="${i}" ${i eq teacher.teaAge ? "selected='selected'":""}>${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                教师入职日期：
            </td>

            <td align="center">
                <input type="text" name="teaDate" value="${teacher.teaDate}" class="Wdate" onClick="WdatePicker();"/>
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
