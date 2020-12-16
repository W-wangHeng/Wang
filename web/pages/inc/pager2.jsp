<%@ page contentType="text/html;charset=UTF-8" language="java" %>
当前第${pageInfo.pageNum}页，总共${pageInfo.pages}页，总共条${pageInfo.total}记录
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${pageInfo.hasPreviousPage}">
    <a href="${pageInfo.url}&no=1">首页</a>
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${not pageInfo.hasPreviousPage}">
    首页
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${pageInfo.hasPreviousPage}">
    <a href="${pageInfo.url}&no=${pageInfo.pageNum - 1}">上一页</a>
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${not pageInfo.hasPreviousPage}">
    上一页
</c:if>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${pageInfo.hasNextPage }">
    <a href="${pageInfo.url}&no=${pageInfo.pageNum + 1}">下一页</a>
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${not pageInfo.hasNextPage }">
    下一页
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<c:if test="${pageInfo.hasNextPage }">
    <a href="${pageInfo.url}&no=${pageInfo.pages}">尾页</a>
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${not pageInfo.hasNextPage }">
    尾页
</c:if>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
去 <input onchange="changePage(this);"/>页
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
去<select onchange="window.location.href='${pageInfo.url}&no=' + this.value">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:forEach var="i" begin="1" end="${pageInfo.pages}">
    <option value="${i}" ${pageInfo.pageNum eq i ? "selected='selected'" : ""}>${i}</option>
</c:forEach>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</select>页
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<script>
    function changePage(input){

        //1.确保用户输入的页号是纯数字: /^\d+$/

        //2.确保用户输入的页号介于第1-最后一页之间

        //3.跳转
        window.location.href = "${pageInfo.url}&no=" + input.value;

    }

</script>

