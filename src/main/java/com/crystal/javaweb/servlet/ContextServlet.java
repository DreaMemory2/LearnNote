package com.crystal.javaweb.servlet;

import com.crystal.javaweb.bean.Block;
import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class ContextServlet extends GenericServlet {
    /**
     * <p>{@link ServletContext} (jakarta.java.ServletContext Servlet上下文)</p>
     * <p>1. {@link ServletContext}也是Servlet规范中的一员</p>
     * <p>2. Tomcat服务器实现ServletContext接口</p>
     * <p>org.apache.catalina.core.ApplicationContextFacade implement ServletContext</p>
     * <p>3. 在同一个webapp,同一个应用当中，所有的Servlet对象都是共享同一个ServletContext对象</p>
     * <p>ServletContext对象在服务器启动阶段创建，在服务器关闭的时候销毁<br>
     * 这就是ServletContext对象的生命周期。ServletContext对象是应用级对象</p>
     * <p>4. Tomcat服务器中有一个webapps，这个webapps下可以存放webapp，通常情况下一个webapp对应一个ServletContext对象</p>
     * <p>一个ServletContext对象通常对应的是一个web.xml文件</p>
     * <p>5. ServletContext接口中常用的方法</p>
     * <ul>
     *     <li>{@link ServletContext#getInitParameter(String)}  通过初始化参数的name获取value</li>
     *     <li>{@link ServletContext#getInitParameterNames()} 获取所有的初始化参数的name </li>
     *     <li>{@link ServletContext#getContextPath()} 获取应用的根路径</li>
     *     <li>{@link ServletContext#getRealPath(String)} 获取文件的绝对路径（真实路径）</li>
     *     <li>{@link ServletContext#log(String)} // 通过ServletContext对象来记录日志</li>
     * </ul>
     * <p>6.ServletContext对象，又叫做: 应用域 </p>
     * <p>如果所有的用户共享一份数据，并且这个数据很少的被修改，并且这个数据量很少，可以将这些数据放到ServletContext这个应用域中</p>
     * <ul>
     *     <li>{@link ServletContext#setAttribute(String, Object)} 存（怎么向ServletContext应用域中存数据）</li>
     *     <li>{@link ServletContext#getAttribute(String)} 取（怎么从ServletContext应用域中取数据）</li>
     *     <li>{@link ServletContext#removeAttribute(String)} 删（怎么删除ServletContext应用域中的数据）</li>
     * </ul>
     *
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 获取Servlet对象
        ServletContext application = getServletContext();
        out.print("ServletContext对象: " + application);
        // 获取ServletContext配置信息
        Enumeration<String> names = application.getInitParameterNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            String parameter = application.getInitParameter(element);
            out.print("<br>" + element + " : " + parameter);
        }
        // 获取应用的根路径, 因为这个方法可以动态获取应用的根路径
        // 在Java源码当中，不要将应用的根路径写死
        String contextPath = application.getContextPath();
        out.print("<br>" + contextPath);
        // 获取Servlet应用对象的名称
        String servletName = getServletConfig().getServletName();
        // 获取文件的绝对路径（真实路径）
        String realPath = application.getRealPath(servletName);
        out.print("<br>" + realPath);
        // 存（怎么向ServletContext应用域中存数据）
        Block block = new Block(1, "grass_block");
        application.setAttribute("草方块", block);
        log("保存方块信息成功 " + block);
        // 取（怎么从ServletContext应用域中取数据）
        application.getAttribute("草方块");
        log("获取方块信息成功 " + block);
        // 删（怎么删除ServletContext应用域中的数据）
        application.removeAttribute("草方块");
        log("删除方块信息成功 " + block);
    }
}
