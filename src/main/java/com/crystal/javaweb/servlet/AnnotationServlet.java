package com.crystal.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>{@link WebServlet}</p>
 * <p>{@code jakarta.servlet.annotation.WebServlet}</p>
 * <p>只能在Servlet类上使用注解：@WebServlet</p>
 * <ul>
 *     <li>name属性：用来指定Servlet的名字，等同于: &lt;servlet-name&gt;</li>
 *     <li>urlPatterns属性：用来指定Servlet的映射路径，可以指定多个字符串，等同于：&lt;url-pattern&gt;</li>
 *     <li>loadOnStartUp属性：用来指定在服务器启动阶段是否加载该Servlet，等同于：&lt;load-on-startup&gt;</li>
 *     <li>value属性：当注解的属性名是value的时候，使用注解的时候，value属性名是可以省略的</li>
 * </ul>
 * <p>注意：不是必须将所有属性都写上，只需要提供需要的</p>
 * <p>注意：属性是一个数组，如果数组中只有一个元素，使用该注解的时候，属性值的大括号可以省略</p>
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
@WebServlet(name = "AnnotationServlet", urlPatterns = "/annotation")
public class AnnotationServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 获取ServletName
        out.print("Servlet name = " + request.getServerName() + "<br>");
        // 获取ServletPath
        out.print("Servlet path = " + request.getServletPath() + "<br>");
    }
}
