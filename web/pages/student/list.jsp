<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>学生管理</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>


        function del(id) {
            if (confirm("确认删除吗？")) {
                window.location.href =
                    "${pageContext.request.contextPath}/student/delete?stuId=" + id
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
            <h1>学生信息查询修改</h1>
        </td>
    </tr>
    <form action="${pageContext.request.contextPath}/student/list" method="post">
        <tr align="center" style="align-content: center">

            <td colspan="2" align="center">学生姓名：<input type="text" name="stuName" value="${student.stuName}"/></td>
            <td colspan="2" align="center">学生性别：
                <input type="radio" name="stuSix" value=""/>忽略
                <input type="radio" name="stuSix" value="男" ${student.stuSix eq "男"?"checked='checked'":""}/>男
                <input type="radio" name="stuSix" value="女" ${student.stuSix eq "女"?"checked='checked'":""}/>女
            </td>
            <td colspan="2" rowspan="2" align="center">
                <input type="submit" value="查询"/>
            </td>
        </tr>

        <tr align="center" style="align-content: center">
            <td colspan="2" align="center">
                学生状态:<select name="stuStatus">
                <option value="">请选择学生在校状态</option>
                <option value="在校" ${student.stuStatus eq "在校"?"selected='selected'":""}>在校</option>
                <option value="离校" ${student.stuStatus eq "离校"?"selected='selected'":""}>离校</option>
                <option value="休学" ${student.stuStatus eq "休学"?"selected='selected'":""}>休学</option>
                <option value="毕业" ${student.stuStatus eq "毕业"?"selected='selected'":""}>毕业</option>
            </select>
            </td>
            <td colspan="2" align="center">
                班主任：<select name="teaId">
                <option value="">请选择学生班主任</option>
                <c:forEach items="${teacher}" var="tea">
                    <option value="${tea.teaId}" ${student.teaId eq tea.teaId ?"selected='selected'":""}>${tea.teaName}</option>
                </c:forEach>
                <%-- <option value="1" ${student.teaId eq "1"?"selected='selected'":""}>王老师</option>
                 <option value="2" ${student.teaId eq "2"?"selected='selected'":""}>李老师</option>
                 <option value="3" ${student.teaId eq "3"?"selected='selected'":""}>张老师</option>
                 <option value="4" ${student.teaId eq "4"?"selected='selected'":""}>程老师</option>--%>
            </select>
            </td>
        </tr>

    </form>

    <tr align="center" style="align-content: center">

        <td>
            <input type="checkbox" id="selectAll"/>
            全选
        </td>
        <td align="center">
            学生姓名
        </td>
        <td align="center">
            学生性别
        </td>
        <td align="center">
            学生状态
        </td>
        <td align="center">
            班主任
        </td>
        <td>
            编辑
        </td>
    </tr>

    <form id="teaForm" action="${pageContext.request.contextPath}/student/delBatch" method="post">
        <c:forEach var="student" items="${studentList}">


            <tr align="center" style="align-content: center">
                <td>
                    <input type="checkbox" name="tIds" value="${student.stuId}"/>
                </td>
                <td align="center">
                        ${student.stuName}
                </td>
                <td align="center">
                        ${student.stuSix}
                </td>
                <td align="center">
                        ${student.stuStatus}
                </td>
                <td align="center">
                        ${student.teacher.teaName}
                </td>

                <td align="center">
                    <a href="${pageContext.request.contextPath}/student/add?stuId=${student.stuId}">修改</a>
                    <br/>
                    <a href="javascript:del(${student.stuId});">删除</a>
                </td>
            </tr>
        </c:forEach>

    </form>

    <tr align="center" style="align-content: center">
        <td colspan="6" align="center">
            <a href="javascript:delBatch();">批量删除</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/student/edit?teaId=${student.teaId}">添加学生信息</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/index">返回主菜单</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/loginOut">退出</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <c:if test="${ !empty teaId }">
                <a href="${pageContext.request.contextPath}/teacher/list">老师管理页</a>
            </c:if>
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
