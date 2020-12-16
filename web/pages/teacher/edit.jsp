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
    <title>教师信息添加界面</title>

    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/js/datePicker/WdatePicker.js"></script>

</head>
<body>
<form action="${pageContext.request.contextPath}/teacher/saveInsert" method="post">
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
                <input type="text" name="teaName"/>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                教师性别：
            </td>
            <td align="center">
                <input type="radio" name="teaSex" value="男"/>男
                <input type="radio" name="teaSex" value="女"/>女
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                教师年龄：

            </td>

            <td align="center">
                <select name="teaAge">
                    <c:forEach var="i" begin="1" end="99">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr align="center" style="align-content: center">
            <td align="center">
                教师入职日期：
            </td>

            <td align="center">
                <input type="text" name="teaDate" class="Wdate" onClick="WdatePicker();"/>
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
