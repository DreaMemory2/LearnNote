package com.crystal.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * <p>编写一个标准通用Servlet</p>
 * <p>以后Servlet对象不要直接实现Servlet接口了</p>
 * <p>以后Servlet对象都要继承CommonServlet类</p>
 * <p>{@link CommonServlet}就是一个适配器</p>
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public abstract class CommonServlet implements Servlet {
    // 成员变量
    private ServletConfig config;
    /**
     * <p>因为这个方法最常用</p>
     * <p>因此子类必须实现service方法</p>
     */
    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    /**
     * <p>ServletConfig对象中封装了&lt;servlet&gt;&lt;/servlet&gt;标签中的配置信息</p>
     * <p>Servlet对象是Tomcat服务器创建，并且ServletConfig对象也是Tomcat服务器创建</p>
     * <p>默认情况下，用户发送第一次请求的时候创建，且一个Servlet对应一个ServletConfig对象</p>
     * <p>ServletConfig接口的实现类是Tomcat服务器给实现的</p>
     *
     * @param config Servlet对象的配置信息对象
     */
    @Override
    public final void init(ServletConfig config) {
        this.config = config;
        // org.apache.catalina.core.StandardWrapperFacade
        /* System.out.println(config); */
        this.init();
    }

    /**
     * <p>提供子类重写</p>
     */
    public void init() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}