<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>新增部门</title>
  <link rel="stylesheet" href="../css/department-form.css">
</head>
<body>
  <div>
    <h1>新增部门</h1>
    <form action="<%=request.getContextPath() + "/department/save"%>" method="post">
      <label><span>部门编号：</span><input type="text" name="number" /></label>
      <label><span>部门名称：</span><input type="text" name="name" /></label>
      <label><span>部门位置：</span><input type="text" name="location" /></label>
      <label><span>&nbsp;</span> <input type="submit" class="button" value="保存" /></label>
   </form>
  </div>
</body>
</html>