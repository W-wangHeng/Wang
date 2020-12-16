<%--
  Created by IntelliJ IDEA.
  User: WangHeng
  Date: 2020/12/15
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师页面</title>

    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/js/datePicker/WdatePicker.js"></script>
    <script>


        function del(id) {
            if (confirm("确认删除吗？")) {
                window.location.href =
                    "${pageContext.request.contextPath}/teacher/delete?teaId=" + id
            }

        }

        function delBatch() {
            if ($("[name=\"tIds\"]:checked").length > 0) {

                if (confirm("确认要删除吗？")) {
                    $("#teaForm").submit();
                }

            } else {
                alert("请至少选一项进行删除！")
            }

        }

        //要改
        $(function () {
            $("#selectAll").click(function () {
                // $("[name=\"teaIds\"]").prop("checked",this.checked);
                $("[name=\"tIds\" ]").prop("checked", $(this).prop("checked"));
            });

        });
    </script>
</head>
<body>
<table align="center" border="1px">
    <tr align="center" style="align-content: center">
        <td colspan="6">
            <h1>教师信息查询修改</h1>
        </td>
    </tr>

    <form action="${pageContext.request.contextPath}/teacher/list" method="post">
        <tr align="center" style="align-content: center">

            <td colspan="2" align="center">教师姓名：
                <input type="text" name="teaName" value="${teacher.teaName}"/>
            </td>
            <td colspan="2" align="center">教师性别：
                <input type="radio" name="teaSex" value=""/>忽略
                <input type="radio" name="teaSex" value="男" ${teacher.teaSex eq "男"?"checked='checked'":""}/>男
                <input type="radio" name="teaSex" value="女" ${teacher.teaSex eq "女"?"checked='checked'":""}/>女
            </td>
            <td colspan="2" rowspan="2" align="center">
                <input type="submit" value="查询"/>
            </td>
        </tr>

        <tr align="center" style="align-content: center">
            <td colspan="2" align="center">
                教师年龄：<input type="text" name="teaStartAge" value="${teacher.teaStartAge}"/>
                至<input type="text" name="teaEndAge" value="${teacher.teaEndAge}"/>
            </td>
            <td colspan=" 2" align="center">
                教师入职日期：
                <input type="text" name="teaStartDate" value="${teacher.teaStartDate}" class="Wdate"
                       onClick="WdatePicker();"/>至
                <input type="text" name="teaEndDate" value="${teacher.teaEndDate}" class="Wdate"
                       onClick="WdatePicker();"/>
            </td>
        </tr>
    </form>

    <tr align="center" style="align-content: center">

        <td>
            <input type="checkbox" id="selectAll"/>
            全选
        </td>
        <td align="center">
            教师姓名
        </td>
        <td align="center">
            教师性别
        </td>
        <td align="center">
            教师年龄
        </td>
        <td align="center">
            教师入职日期
        </td>
        <td>
            编辑
        </td>
    </tr>

    <form id="teaForm" action="${pageContext.request.contextPath}/teacher/delBatch" method="post">
        <c:forEach var="teacher" items="${teacherList}">

            <tr align="center" style="align-content: center">
                <td>
                    <input type="checkbox" name="tIds" value="${teacher.teaId}"/>
                </td>
                <td align="center">
                        ${teacher.teaName}
                </td>
                <td align="center">
                        ${teacher.teaSex}
                </td>
                <td align="center">
                        ${teacher.teaAge}
                </td>
                <td align="center">
                        ${teacher.teaDate}
                </td>

                <td align="center">
                    <a href="${pageContext.request.contextPath}/teacher/add?teaId=${teacher.teaId}">修改</a>
                    <a href="javascript:del(${teacher.teaId});">删除</a>
                    <br/>
                    <a href="${pageContext.request.contextPath}/teacher/selectStudent?teaId=${teacher.teaId}">学生 管理</a>
                </td>
            </tr>
        </c:forEach>

    </form>

    <tr align="center" style="align-content: center">
        <td colspan="6" align="center">
            <a href="javascript:delBatch();">批量删除</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/teacher/edit">添加教师信息</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/">返回主菜单</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/loginOut">退出</a>
        </td>
    </tr>

    <tr align="center" style="align-content: center">
        <td colspan="6" align="center">
            当前第${pager.no}页,共${pager.totalPageNo}页,共${pager.totalRowCount}条数据
            &nbsp;&nbsp;&nbsp;
            <c:if test="${pager.no eq 1 }">
                首页
            </c:if>

            <c:if test="${pager.no ne 1 }">
                <a href="${pager.url}&no=1">首页</a>
            </c:if>
            &nbsp;&nbsp;&nbsp;
            <c:if test="${pager.no eq 1 }">
                上一页
            </c:if>

            <c:if test="${pager.no ne 1 }">
                <a href="${pager.url}&no=${pager.no-1}">上一页</a>
            </c:if>
            &nbsp;&nbsp;&nbsp;
            <c:if test="${pager.no eq pager.totalPageNo }">
                下一页
            </c:if>

            <c:if test="${pager.no ne pager.totalPageNo }">
                <a href="${pager.url}&no=${pager.no+1}">下一页</a>
            </c:if>
            &nbsp;&nbsp;&nbsp;
            <c:if test="${pager.no eq pager.totalPageNo }">
                尾页
            </c:if>

            <c:if test="${pager.no ne pager.totalPageNo }">
                <a href="${pager.url}&no=${pager.totalPageNo}">尾页</a>
            </c:if>
            &nbsp;&nbsp;&nbsp;
            去<input type="text" onchange="changePage(this)">页
            去<select onchange="window.location.href ='${pager.url}&no='+this.value">
            <c:forEach var="i" begin="1" end="${pager.totalPageNo}">

                <option value="${i}" ${pager.no eq i ?"selected=selected":""}>${i}</option>
            </c:forEach>

        </select>页


        </td>
    </tr>
    <script>
        function changePage(input) {
            window.location.href = "${pager.url}&no=" + input.value;

        }
    </script>


</table>

</body>
</html>
