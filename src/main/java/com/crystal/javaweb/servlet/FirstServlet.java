package com.crystal.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * <p>如何让服务器启动的时候创建Servlet对象呢</p>
 * <p>只需添加: 在servlet标签中添加<load-on-startup>子标签，在该子标签中填写整数，越小的整数优先级越高</p>
 * <p>总结现象:</p>
 * <ul>
 *     <li>第一：Servlet对象是单例的<br>
 *     但是要注意：Servlet对象是单实例的，但是Servlet类并不符合单例模式。我们称之为假单例</li>
 *     <li>第二：无参数构造方法、init方法只在第一次用户发送请求的时候执行</li>
 *     <li>第三：只要用户发送一次请求：service方法必然会被Tomcat服务器调用一次</li>
 * </ul>
 * <p>关于Servlet类中方法的调用次数</p>
 * <ul>
 *     <li>构造方法只执行一次</li>
 *     <li>init方法只执行一次</li>
 *     <li>service方法：用户发送一次请求则执行一次，发送N次请求则执行N次</li>
 *     <li>destroy方法只执行一次</li>
 * </ul>
 *
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class FirstServlet implements Servlet {
    private ServletConfig config;

    /**
     * <p>当用户第一次访问http://localhost:8080/servlet/first网站时，该对象才可以被创建出来</p>
     * <p>当该对象创建出来则调用无参数构造方法</p>
     * <p>用户在发送第一次请求的时候Servlet对象被实例化[Servlet对象的构造方法被执行了。并且执行的是无参数构造方法]</p>
     */
    public FirstServlet() {
        System.out.println("无参数构造方法执行");
    }

    /**
     * <p>调用无参数构造方法后，紧接着调用init()方法</p>
     * <p>Servlet对象被创建出来之后，Tomcat服务器马上调用了Servlet对象的init方法</p>
     * <p>通常在init方法当中做初始化操作，初始化数据库连接池，初始化线程池</p>
     *
     * <p>这个无参数构造方法可以代替掉init方法吗？</p>
     * <p>不能：Servlet规范中有要求，因为不建议手动编写构造方法，因为编写构造方法，很容易让无参数构造方法
     * 消失，这个操作可能会导致Servlet对象无法实例化。所以init方法是有存在的必要的</p>
     * @param servletConfig Servlet配置
     */
    @Override
    public void init(ServletConfig servletConfig) {
        this.config = servletConfig;
        System.out.println("init()方法已执行");
    }

    /**
     * <p>调用init()方法，紧接着调用service()方法<br>
     * 此后，无论用户访问都多少次，都会调用同一个Servlet对象，调用同一个Service方法</p>
     * <p>用户在发送多次时，Servlet对象并没有新建，还是使用之前创建好的Servlet对象，直接调用该Servlet对象的service方法</p>
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()方法已执行");
    }

    /**
     * <p>当服务器关闭后destroy方法才能执行</p>
     * <p>服务器在销毁Servlet对象内存之前，Tomcat服务器会自动调用Servlet对象的destroy方法</p>
     * <p>destroy方法执行的时候Servlet对象还在，没有被销毁。destroy方法执行结束之后，Servlet对象的内存才会被Tomcat释放</p>
     * <p>通常在destroy方法当中，进行保存资源或关闭资源</p>
     */
    @Override
    public void destroy() {
        System.out.println("destroy()方法已执行");
    }

    @Override
    public String getServletInfo() {
        return this.config.getServletName();
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
}
