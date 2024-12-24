<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>查看部门</title>
    <link rel="stylesheet" href="../css/department-form.css">
</head>
<body>
<div>
    <h1>查看部门</h1>
    <div class="container">
        <label><span>部门编号：</span><input type="text" name="number" value="${department.id}" readonly /></label>
        <label><span>部门名称：</span><input type="text" name="name" value="${department.name}" readonly /></label>
        <label><span>部门位置：</span><input type="text" name="location" value="${department.location}" readonly /></label>
        <label><span>&nbsp;</span> <input type="button" class="button" value="后退" onclick="window.history.back()" /></label>
    </div>
</div>
</body>
</html>