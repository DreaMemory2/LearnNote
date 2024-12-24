package com.crystal.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class ConfigServlet extends GenericServlet {
    /**
     * <p>ServletConfig (jakarta.servlet.ServletConfig Servlet对象配置信息 )</p>
     * <p>1. ServletConfig是Servlet规范的一员，也是一个接口</p>
     * <p>2. Tomcat服务器实现的类，Tomcat实现ServletConfig接口</p>
     * <p>org.apache.catalina.core.StandardWrapperFacade implement {@link ServletConfig}</p>
     * <p>3. 一个Servlet对象中有一个ServletConfig对象</p>
     * <p>4. 当Servlet对象创建时，同时创建ServletConfig对象</p>
     * <p>5. ServletConfig对象中封装了&lt;servlet&gt;标签中的配置信息</p>
     * <p>6.其中&lt;servlet&gt;标签中的&gt;init-param&lt;标签是初始化参数，用来将初始化信息，封装到ServletConfig对象中</p>
     * <p>ServletConfig接口的常用方法</p>
     * <ul>
     *     <li>{@link ServletConfig#getInitParameter(String)}方法: 通过初始化参数的name获取value</li>
     *     <li>{@link ServletConfig#getInitParameterNames()}方法: 获取所有的初始化参数的name</li>
     *     <li>{@link ServletConfig#getServletContext()}方法: 获取ServletContext对象</li>
     *     <li>{@link ServletConfig#getServletName()}方法: 获取Servlet的name</li>
     * </ul>
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        // 输出该对象
        out.print("ServletConfig对象: " + this.getServletConfig());
        // 获取ServletName的名字
        out.print("<br>&lt;servlet-name&gt;" + config.getServletName() + "&lt;servlet-name&gt;");
        //  通过ServletConfig对象的两个方法，可以获取配置文件中的初始化配置信息
        // 获取所有的初始化信息
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            // 通过初始化参数名字Name获取Value
            String parameter = config.getInitParameter(element);
            out.print("<br>" + element + " : " + parameter);
        }
    }

    /**
     * <p>如果子类想要重写init方法，需要init()方法重载</p>
     */
    @Override
    public void init() {
        this.log("init方法已经执行");
    }
}
