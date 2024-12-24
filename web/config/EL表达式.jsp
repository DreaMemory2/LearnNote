<%@ page import="com.crystal.javaweb.bean.Block" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    // 向request作用域中存储username信息
    request.setAttribute("username", "张三");
    // 创建Block对象
    Block block = new Block(1, "block");
    // 将Block对象存储到request域当中
    request.setAttribute("block", block);
    // 向request存储数据
    request.setAttribute("request", "request");
    // 数组对象
    int[] arrays = {1, 2, 3};
    // 向域中存储数组
    request.setAttribute("arrays", arrays);
%>

<%-- 将request域当中的数据取出来，并且还要输出浏览器当中，使用EL表达式 --%>
${username}
<%-- 获取Block对象的name属性，一定创建get方法 --%>
${block.name}
<%-- 获取Block对象的name属性第二种方式，注意[]当中添加双引号 --%>
${block["name"]}

<%-- 在EL表达式中，如果添加双引号，则EL表达式就会当作普通字符串输出到浏览器中 --%>

<%-- 往四个域都存储了数据，并且name相同 --%>
<%-- EL表达式优先从小范围中取数据 --%>
<%-- pageContext < request < session < application --%>
${request}

<%-- EL表达式有4个隐式的范围对象 --%>
<%-- PageScop RequestScope SessionScope ApplicationScope --%>
${requestScope.request}

<%-- EL表达式主要任务是要做页面展示，最终页面展示为空 --%>
${nulls}

<%-- 使用EL表达取出数组中的元素 --%>
${arrays} <%-- 将数组对象直接输出 --%>

<%-- 当添加isELIgnored="true"时，EL表达式失效，当成普通字符串了 --%>
<%-- 可以使用反斜杠，忽略其中一个EL表达式 --%>
\${username}

<%-- 在EL表达式当中没有request这个隐式对象 --%>
<%-- requestDcope这个代表"请求范围", 不等同于request对象 --%>
<%-- EL表达式中的pageContext对象等于JSO内置对象是同一个对象 --%>
${pageContext.request}
${pageContext.request.contextPath}

<%-- 假设用户提交的数据为：http://localhost:8080/jsp/EL表达式?username=张三&password=123 --%>

<%--
EL表达式的运算符
算术运算符  + - * / %
关系运算符 == != > >= < <= eq
逻辑运算符 ! && || not and or
条件运算符 ? :
取值运算符 [] 和 .
empty运算符
    - empty运算符的结果是boolean类型
    - ${empty param.username}
    - ${not empty param.username}
    - ${!empty param.password}
--%>