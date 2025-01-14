<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAX中的Post请求</title>
</head>
<body>
    <%-- 经典案例：使用AJAX POST请求实现用户注册的时候，用户名是否可用 --%>
    用户名：<input type="text" id="username"/><br>
    密码：<input type="password" id="password"/><br>
    <input type="button" id="button" value="hello" />
    <div id="container"></div>

    <script type="text/javascript">
        window.onload = function (){
            document.getElementById("button").onclick = function (){
                // 发送AJAX POST请求
                // 1. 创建AJAX核心对象
                let request = new XMLHttpRequest();
                // 2. 注册回调函数
                request.onreadystatechange = function (){
                    if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("container").innerHTML = this.responseText;
                    }
                };
                // 3. 开启通道
                request.open("POST", "/web/test03", true);
                // 4. 发送请求
                /* 模拟AJAX提交form表单，设置请求头的内容类型 */
                request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

                /* 放到send()这个函数的小括号当中的数据，会自动在请求体当中提交数据
                   使用JS代码获取用户名和密码
                   注意格式：放在这里的数据就是在请求体当中提交，格式要遵循HTTP协议
                */
                let username = document.getElementById('username').value;
                let password = document.getElementById('password').value;
                request.send("username=" + username + "&password=" + password);
            }
        }
    </script>
</body>
</html>
