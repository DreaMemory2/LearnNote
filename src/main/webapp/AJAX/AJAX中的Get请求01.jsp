<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>AJAX中的Get请求</title>
</head>
<body>
    <%-- 给一个按钮，用户点击这个按钮的时候发生AJAX请求 --%>
    <input type="button" value="Hello AJAX" id="button"/>
    <%-- 给一个div图层，AJAX接收了响应的数据之后，在div中进行渲染 --%>
    <div id="container"></div>

    <script type="text/javascript">
        window.onload = function() {
            document.getElementById("button").onclick = function() {
                // 发送AJAX get请求
                console.log('AJAX中的Get请求');
                // 1. 第一步：创建AJAX核心对象XMLHttpRequest
                let request = new XMLHttpRequest();
                // 2. 第二步：注册回调函数
                request.onreadystatechange = function() {
                    /* 这是一个回调函数，这个函数在XMLHttpRequest对象的readyState状态值发生改变时调用 */
                    // 这里的回调函数会被调用多次
                    /*console.log(request.readyState);*/

                    /* 当XMLHttpRequest对象的readyState的状态为4时，表示响应结束了 */
                    if (this.readyState === 4) {
                        // 响应结束
                        /* 响应结束后，一般会有一个HTTP的状态码 */
                        // HTTP状态码常见包括：200表示成功，404表示资源找不到，500表示服务器内部错误，是HTTP协议的一部分
                        console.log('HTTP响应的状态码: ' + this.status);
                        if (this.status === 400) {
                            alert('您访问的资源找不到，检查请求路径');
                        } else if (this.status === 200) {
                            /* 通过XMLHttpRequest对象获取响应的信息
                               通过XMLHttpRequest对象中的requestText属性获取响应的信息
                               把响应信息放到div图层当中渲染
                            */
                            document.getElementById('container').innerHTML = this.responseText;
                        }
                    }
                };
                // 3. 第三步：开启通道(open只是浏览器和服务器建立链接, 通道打开, 并不会发生请求)
                /*
                  1. XMLHttpRequest中的open方法中有五个参数
                    - method: 请求的方式：get或者post
                    - url: 请求的路径
                    - async: 只能是true或者false, true表示此AJAX请求是一个异步请求; false表示此AJAX请求是一个同步请求
                    - user: 用户名，用来进行身份认证，说明访问这个服务器上的资源，可能需要提供一些才能访问
                    - psw: 密码
                */
                request.open('GET', '/web/test01', true);
                // 4. 第四步：发送请求
                request.send();
            };
        };
    </script>
</body>
</html>
