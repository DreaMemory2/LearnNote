package com.crystal.javaweb.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * <p>1.1 在web.xml文件中对Filter进行配置。这个配置和Servlet很像</p>
 * <pre>
 *     &lt;filter&gt;
 *         &lt;filter-name>Filter&lt;/filter-name&gt;
 *         &lt;filter-class>com.crystal.javaweb.filter.FilterServlet&lt;/filter-class&gt;
 *     &lt;/filter&gt;
 *     &lt;filter-mapping&gt;
 *          &lt;filter-name&gt;Filter&lt;/filter-name&gt;
 *          &lt;url-pattern&gt;/filter&lt;/url-pattern&gt;
 *     &lt;/filter-mapping&gt;
 * </pre>
 * <p>1.2 或者使用注解：@WebFilter({"*.do"})</p>
 * <p>关于Filter的配置路径</p>
 * <ul>
 *     <li>/a.do、/b.do这些配置方式都是精确匹配</li>
 *     <li>/* 匹配所有路径</li>
 *     <li>*.do 后缀匹配。不要以 / 开始</li>
 *     <li>/dept/*  前缀匹配</li>
 * </ul>
 * <p>2.1 依靠filter-mapping标签的配置位置，越靠上优先级越高</p>
 * <p>2.2 使用@WebFilter的时候，Filter的执行顺序是怎样的呢？</p>
 * <p>执行顺序是：比较Filter这个类名</p>
 * <p>比如：FilterA和FilterB，则先执行FilterA</p>
 * <p>比如：Filter1和Filter2，则先执行Filter1</p>
 * <p>3. Filter的生命周期和Servlet对象生命周期一致</p>
 * <p>Filter默认情况下，在服务器启动阶段就实例化。Servlet不会</p>
 * <p>4. 责任链设计模式</p>
 * <p>在程序编译阶段不会确定调用顺序。因为Filter的调用顺序是配置到web.xml文件中的，
 * 只要修改web.xml配置文件中filter-mapping的顺序就可以</p>
 * <p>因此Filter的执行顺序是在程序运行阶段动态组合的。那么这种设计模式被称为责任链设计模式</p>
 * <p>责任链设计模式最大的核心思想：</p>
 * <p>在程序运行阶段，动态的组合程序的调用顺序</p>
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
/* 以下这个路径属于模糊匹配的扩展匹配 */
@WebFilter({"/filter", "*.do"})
public class FilterServlet implements Filter {
    private FilterConfig config;
    private ServletContext context;

    public FilterServlet() {
        System.out.println("无参数构造方法执行");
    }

    /**
     * <p>init方法：在Filter对象第一次被创建之后调用，并且只调用一次</p>
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        this.context = filterConfig.getServletContext();
        context.log("init方法执行");
    }

    /**
     * <p>doFilter方法：只要用户发送一次请求，则执行一次。发送N次请求，则执行N次。在这个方法中编写过滤规则</p>
     * <p>Servlet对象默认情况下，在服务器启动的时候是不会新建对象的</p>
     * <p>Filter对象默认情况下，在服务器启动的时候会新建对象</p>
     * <p>Servlet是单例的。Filter也是单例的</p>
     * <p>注意：Filter的优先级，天生的就比Servlet优先级高</p>
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String name = config.getFilterName();
        context.log(name);
        /* 在请求的时候添加过滤规则 */
        context.log("doFilter方法开始执行");
        // 执行在一个过滤器，如果下一个不是过滤器，则执行目标程序Servlet
        chain.doFilter(request, response);
        /* 在响应的时候添加过滤规则 */
        context.log("doFilter方法执行结束");
    }

    /**
     * <p>destroy方法：在Filter对象被释放/销毁之前调用，并且只调用一次</p>
     */
    @Override
    public void destroy() {
        context.log("destroy方法执行");
    }
}
