<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>修改部门</title>
    <link rel="stylesheet" href="../css/department-form.css">
</head>
<body>
<div>
    <h1>修改部门</h1>
    <form action="<%=request.getContextPath() + "/department/modify"%>" method="post">
        <label><span>部门编号：</span><input type="text" name="number" value="${department.id}" readonly /></label>
        <label><span>部门名称：</span><input type="text" name="name" value="${department.name}" /></label>
        <label><span>部门位置：</span><input type="text" name="location" value="${department.location}" /></label>
        <label><span>&nbsp;</span> <input type="submit" class="button" value="修改" /></label>
    </form>
</div>
</body>
</html>