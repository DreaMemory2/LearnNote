<%-- JSP专业注释 --%>
<%--
1. JSP
    - JSP是java程序（JSP本质还是一个Servlet）
    - JSP是：JavaServer Pages的缩写，是JavaEE的13个子规范之一
2. JSP与Servlet区别
    - Servlet的强项是逻辑处理，业务处理
    - JSP的强项是做数据的展示
3. <% String name = “jack”;  out.write("name = " + name); %>
    - 以上代码中的out是JSP的九大内置对象之一。可以直接拿来用
4. JSP基本语法
    - <% %> ：在这个符号当中编写的被视为java程序，被翻译到Servlet类的service方法内部
    - <%! %> ：在这个符号当中编写的java程序会自动翻译到service方法之外，存在线程安全问题
        + 因为JSP是单例的，多线程并发的环境下，这个静态变量和实例变量一旦有修改操作，必然会存在线程安全问题
    - <%= %> ： 输出的内容中含有“java代码”
--%>
<%-- 通过page指令来设置响应的内容类型，在内容类型的最后面添加：charset=UTF-8 --%>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>我的网页</title>
</head>
<body>
    <%
        // 动态获取项目的名字
        String path = request.getContextPath();
        // 动态获取Servlet的名字
        String servletPath = request.getServletPath();
        application.log(servletPath);
    %>
    <%-- 编写Java语句 --%>
    <% application.log("Hello World"); %>
    <%-- 在service方法当中编写的代码是有顺序的，方法体当中的代码要遵循自上而下的顺序依次逐行执行 --%>
    <% application.log("Hello JSP"); %>
    <%-- 翻译到service方法体内部，翻译为：out.print(); --%>
    <%= "System.out.println('Hello World')" %>
    <a href="<%= path + "/department/list" %>">部门列表</a>
</body>
</html>