<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 引入标签库，这里引入的是JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>部门列表</title>
    <link rel="stylesheet" href="../css/department-core.css">
</head>
<body>
<%
    String path = request.getContextPath();
    request.setAttribute("path", path);
%>

<script type="text/javascript">
    function deletes(number) {
        var ok = window.confirm("确认删除吗？");
        if (ok) {
            document.location.href = "<%= path %>/department/delete?number=" + number;
        }
    }
</script>

<table>
    <thead>
    <tr>
        <th>序号</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门地址</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

        <%-- 循环遍历 --%>
        <c:forEach items="${department}" varStatus="departmentCount" var="department" >
        <tr>
            <td>${departmentCount.count}</td>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>${department.location}</td>
            <td>
                <a href="javascript:void(0)" onclick="deletes(${department.id})">删除</a>
                <a href="${path}/department/check?value=modify&number=${department.id}">修改</a>
                <a href="${path}/department/check?value=detail&number=${department.id}">详情</a>
            </td>
        </tr>
        </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="5"><a href="<%= path + "/jsp/department-add.jsp"%>">新增部门</a></td>
    </tr>
    </tfoot>
</table>
</body>
</html>