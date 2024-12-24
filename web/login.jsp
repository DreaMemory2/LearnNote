<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh_cn">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>登录页面</title>
  <link rel="stylesheet" href="css/login.css">
</head>

<body>
<div class="container">
  <div class="login">Login</div>
  <!-- 注意：浏览器上编写的这个请求路径还是带上应用的根路径 -->
  <form action="<%= request.getContextPath() %>/loginServlet" method="post" >
    <div class="form-wrapper">
      <input type="text" name="username" placeholder="请输入用户名" class="input-item">
      <input type="password" name="password" placeholder="请输入密码" class="input-item">
    </div>
    <div class="prove">
      <input type="text" name="proveword" placeholder="请输入验证码" class="input-item">
    </div>
    <div class="signIn"><input type="submit" class="submit" value="登录"></div>
  </form>
  <div class="msg">
    <a href="#">Sign up</a>
  </div>
</div>
</body>

</html>
