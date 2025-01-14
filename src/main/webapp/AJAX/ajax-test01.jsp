<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AJAX Page</title>
</head>
<body>
    <%-- 需求：页面上有一个按钮，用户点击按钮之后，执行一段java代码 --%>
    <input type="button" value="hello" onclick="hello01()" /><br>

    <%-- 通过JS代码给按钮绑定时间 --%>
    <input type="button" value="hello" id="button" />

    <%-- 页面集合 --%>
    <h1>页面集</h1>
    <a href="/web/AJAX/AJAX中的Get请求01.jsp">AJAX中的Get请求01</a><br>
    <a href="/web/AJAX/AJAX中的Get请求02.jsp">AJAX中的Get请求02</a><br>
    <a href="/web/AJAX/AJAX中的Post请求01.jsp">AJAX中的Post请求01</a><br>
    <a href="/web/AJAX/AJAX中的Post请求02.jsp">AJAX中的Post请求02</a><br>

    <script type="text/javascript">
        function hello01() {
            alert('Hello World!');
        }
        window.onload = function() {
            <%-- 页面加载完毕之后，给id绑定鼠标单击事件 --%>
            <%-- 当load事件发生之后，这个回调函数才会执行(页面加载完毕之后) --%>
            <%-- 获取id="button"的对象 --%>
            let element = document.getElementById("button");
            <%-- 给id="button"元素绑定click事件 --%>
            element.onclick = function (){
                <%-- 这个回调函数执行：当element被click的时候，被鼠标单击的时候，这个回调函数会执行 --%>
                alert('Hello World!');
                <%-- 获取按钮上value，而this是发生的click事件源对象，是按钮发生了鼠标单击事件，那么this代表的就是这个按钮对象 --%>
                console.log(this.value);
            }
        }
    </script>
</body>
</html>