<%@ page contentType="text/html;charset=UTF-8" language="java" %>
当前第${pager.no}页，总共${pager.totalPageNo}页，总共条${pager.totalRowCount}记录

<c:if test="${pager.hasPrev}">
    <a href="${pager.url}&no=1">首页</a>
</c:if>

<c:if test="${not pager.hasPrev}">
    首页
</c:if>

<c:if test="${pager.hasPrev}">
    <a href="${pager.url}&no=${pager.no - 1}">上一页</a>
</c:if>

<c:if test="${not pager.hasPrev}">
    上一页
</c:if>


<c:if test="${pager.hasNext}">
    <a href="${pager.url}&no=${pager.no + 1}">下一页</a>
</c:if>

<c:if test="${not pager.hasNext}">
    下一页
</c:if>


<c:if test="${pager.hasNext}">
    <a href="${pager.url}&no=${pager.totalPageNo}">尾页</a>
</c:if>

<c:if test="${not pager.hasNext}">
    尾页
</c:if>

去 <input onchange="changePage(this);"/>页

去<select onchange="window.location.href='${pager.url}&no=' + this.value">

<c:forEach var="i" begin="1" end="${pager.totalPageNo}">
    <option value="${i}" ${pager.no eq i ? "selected='selected'" : ""}>${i}</option>
</c:forEach>

</select>页

<script>
    function changePage(input){

        //1.确保用户输入的页号是纯数字: /^\d+$/

        //2.确保用户输入的页号介于第1-最后一页之间

        //3.跳转
        window.location.href = "${pager.url}&no=" + input.value;

    }

</script>

