<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 引入标签库，这里引入的是JSTL核心标签库 --%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 负责展示是HTML语言，不用编写java语言 --%>

<%
    // 创建List集合
    List<String> list = new ArrayList<>();
    // 添加到List集合当中
    list.add("abc");
    list.add("def");
    list.add("sss");

    request.setAttribute("list", list);
%>

<%-- 需求: 将List集合中的元素进行遍历和输出 --%>
<%-- EL表达式只能从域中取数据 --%>
<c:forEach items="${list}" var="list" varStatus="listStatus">
    <%-- varStatus: 这个属性表示var状态对象 --%>
    <%-- varStatus的count值以1开始自增，用于编号，序号 --%>
    String${listStatus.count}: ${list.toString()}<br>
</c:forEach>

<%-- if标签 --%>
<%-- 将var中的value存储到request域中 --%>
<c:if test="${empty param.username}" var="value" scope="request">
    <h1>用户名不为空</h1>
    <%-- value变量存储的是test属性的值 --%>
    ${value}<br>
    ${pageContext.servletContext.log("用户名不为空")}
</c:if>

<%--
    var 用来指定循环中的变量
    begin 开始
    end 结束
    step 步长
 --%>
<c:forEach var="i" begin="1" end="10" step="1">
    ${i}.文本<br>
</c:forEach>

<%--
    if () {

    } else if () {

    } else {

    }
--%>
<c:choose>
    <c:when test="${param.age < 18}">
        <p>青少年</p>
    </c:when>
    <c:otherwise>
        <p>非法年龄</p>
    </c:otherwise>
</c:choose>