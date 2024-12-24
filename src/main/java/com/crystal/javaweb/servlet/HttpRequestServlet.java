package com.crystal.javaweb.servlet;

import com.crystal.javaweb.bean.Block;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * <p>1. {@link HttpServletRequest}的实现类</p>
 * <p>{@code org.apache.catalina.connector.RequestFacade implement HttpServletRequest}</p>
 * <p>全限定类名：jakarta.servlet.http.HttpServletRequest</p>
 * <p>2. HttpServletRequest是Servlet规范中的一员，其中它的父接口为request</p>
 * <p>{@code public interface HttpServletRequest extends ServletRequest}</p>
 * <p>3. Request和Response的生命周期</p>
 * <p>一个是请求对象，一个是响应对象。这两个对象只在当前请求/响应中有效</p>
 * <p>一次请求对应一个request，一次响应对应一个response</p>
 * <p>4. Request方法常用方法</p>
 * <pre>
 *     // 这种4个方法，和获取用户提交的数据有关系
 *     public String getParameter(String name);
 *     public Enumeration<String> getParameterNames();
 *     public String[] getParameterValues(String name);
 *     public Map<String, String[]> getParameterMap();
 * </pre>
 * <p>5. request对象称为“请求域”对象</p>
 * <p>“请求域”对象要比“应用域”对象范围小很多。生命周期短很多。请求域只在一次请求内有效</p>
 * <p>一个请求对象request对应一个请求域对象。一次请求结束之后，这个请求域就销毁了</p>
 * <p>尽量使用小的域对象，因为小的域对象占用的资源较少</p>
 * <pre>
 *     {@link HttpServletRequest#setAttribute(String, Object)} // 向域当中绑定数据
 *     {@link HttpServletRequest#getAttribute(String)} // 从域当中根据name获取数据
 *     {@link HttpServletRequest#removeAttribute(String)} // 将域当中绑定的数据移除
 * </pre>
 * <pre>
 *     什么情况下会考虑向ServletContext这个应用域当中绑定数据呢?
 *       - 第一：所有用户共享的数据
 *       - 第二：这个共享的数据量很小
 *       - 第三：这个共享的数据很少的修改操作
 *       - 在以上三个条件都满足的情况下，使用这个应用域对象，可以大大提高我们程序执行效率
 * </pre>
 * <p>6. 实际上向应用域当中绑定数据，就相当于把数据放到了缓存（Cache）当中，
 * 然后用户访问的时候直接从缓存中取，减少IO的操作</p>
 * <p>大大提升系统的性能，所以缓存技术是提高系统性能的重要手段</p>
 * <p>7. 使用Servlet转发机制</p>
 * <pre>
 *     {@link HttpServletRequest#getRequestDispatcher(String)} // 获取请求转发器对象
 *     {@link RequestDispatcher#forward(ServletRequest, ServletResponse)} // 调用转发器的forward方法完成跳转/转发
 * </pre>
 * <p>8. {@link HttpServlet}的常用方法</p>
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class HttpRequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print(request.toString());
        log(request.toString());

        // 请求信息
        // 获取用户提交的数据信息
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            String parameter = request.getParameter(element);
            out.print("<br>" + element + ": " + parameter);
        }

        /* 请求域 */
        Block block = new Block(1, "glass_block");
        // 向域中绑定数据
        request.setAttribute("glass_block", block);
        log("方块创建成功: " + block);
        // 向域中获取数据
        Block obj = (Block) request.getAttribute("glass_block");
        log("方块获取成功: " + obj.toString());
        // 向域中删除数据
        request.removeAttribute("glass_block");
        log("方块删除成功: " + block);

        // 使用Servlet转发机制
        // 执行AServlet之后，跳转到BServlet，这个资源跳转可以使用转发机制来完成
        // 第一步：获取请求转发器对象
        RequestDispatcher dispatcher = request.getRequestDispatcher("/https/request");
        // 第二步：调用转发器的forward方法完成跳转/转发
        /*dispatcher.forward(request, response);*/

        // 获取客户端的IP地址
        String localAddr = request.getLocalAddr();
        log(localAddr);
        out.print("<br>" + localAddr);

        // 设置请求体的字符集（显然这个方法是处理POST请求的乱码问题。这种方式并不能解决get请求的乱码问题）
        request.setCharacterEncoding("UTF-8");

        // 消除中文乱码问题
        response.setContentType("text/html;charset=UTF-8");

        // 获取应用的根路径
        String contextPath = request.getContextPath();
        log(contextPath);
        out.print("<br>" + contextPath);

        // 获取请求方式
        String method = request.getMethod();
        log(method);
        out.print("<br>" + method);

        // 获取请求的URI
        String uri = request.getRequestURI();
        log(uri);
        out.print("<br>" + uri);

        // 获取servlet path
        String path = request.getServletPath();
        log(path);
        out.print("<br>" + path);

    }
}
