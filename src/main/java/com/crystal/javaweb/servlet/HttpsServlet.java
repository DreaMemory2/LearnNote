package com.crystal.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>{@link HttpServlet}</p>
 * <p>1.因为它是B/S结构的系统，这种系统是基于HTTP超文本传输协议的，所以继承{@link HttpServlet}</p>
 * <p>在Servlet规范当中，提供了一个类叫做HttpServlet，它是专门为HTTP协议准备的一个Servlet类</p>
 * <p>使用HttpServlet处理HTTP协议更便捷</p>
 * <p>2.它的继承结构</p>
 * <pre>
 *     - jakarta.servlet.Servlet（接口）
 *      - jakarta.servlet.GenericServlet implements Servlet（抽象类）
 *        - jakarta.servlet.http.HttpServlet extends GenericServlet（抽象类）
 * </pre>
 * <p>3. 向ServletContext应用域中存储数据，也等于是将数据存放到缓存cache当中了</p>
 *
 * <p>HTTP的请求协议（B -> S）</p>
 *
 * <p>HTTP的请求协议包括：4部分</p>
 * <ul>
 *     <li>请求行</li>
 *     <li>请求头</li>
 *     <li>空白行</li>
 *     <li>请求体</li>
 * </ul>
 *
 * <p>HTTP的请求协议之GET请求</p>
 * <pre>
 *     GET /servlet05/getServlet?username=lucy&password=1111 HTTP/1.1  请求行
 *       Host: localhost:8080                                          请求头
 *                                                                     空白行
 *                                                                     请求体
 * </pre>
 *
 * <p>HTTP的请求协议之POST请求</p>
 *
 * <p>HTTP的响应协议（S -> B）</p>
 * <pre>
 *     GET /servlet05/getServlet HTTP/1.1                              请求行
 *       Host: localhost:8080                                          请求头
 *                                                                     空白行
 *    username=lisi&password=123                                       请求体
 * </pre>
 *
 * <p>HTTP的响应协议包括：4部分</p>
 * <ul>
 *     <li>状态行: 协议版本号+状态码+状态描述信息</li>
 *     <li>响应头: 响应内容类型+ 响应内容长度+ 响应内容时间</li>
 *     <li>空白行: 用来分隔响应头和响应体</li>
 *     <li>响应体: 响应的正文，这些内容是一段长的字符串，被浏览器所渲染执行，展示效果</li>
 * </ul>
 * <pre>
 *    HTTP/1.1 200 ok                         状态行
 *    Content-Type: text/html;charset=UTF-8   响应头
 *    Content-Length: 25
 *    Date: Mon, 16 Dec 2024 16:09:24 GMT
 *                                            空白行
 *    &lt;h1&gt;From get Servlet&lt;/h1&gt;               响应体
 * </pre>
 *
 * <p>200: 表示请求响应成功，正常结束</p>
 * <p>404: 表示访问的资源不存在，前端错误</p>
 * <p>405: 表示前端发送的请求方式于后端请求方式不一致时发生</p>
 * <p>500: 表示服务端的程序出现了异常，服务端的错误</p>
 * <p>以4开始: 浏览器导致; 以5开始: 服务端导致</p>
 *
 * <p>当用户第一次请求的时候</p>
 * <ul>
 *     <li>首先调用无参数构造方法，创建对象</li>
 *     <li>调用有参数{@link jakarta.servlet.GenericServlet#init(ServletConfig)}方法</li>
 *     <li>调用无参数构成方法 {@link GenericServlet#init()}方法</li>
 *     <li>接着调用{@link HttpServlet#service(ServletRequest, ServletResponse)}方法</li>
 *     <li>再调用{@link HttpServlet#service(HttpServletRequest, HttpServletResponse)}方法</li>
 * </ul>
 *
 * <p>终于得到了最终的一个Servlet类的开发步骤：</p>
 * <ul>
 *     <li>第一步：编写一个Servlet类，直接继承HttpServlet</li>
 *     <li>第二步：重写doGet方法或者重写doPost方法</li>
 *     <li>第三步：将Servlet类配置到web.xml文件当中</li>
 *     <li>第四步：准备前端的页面（form表单），form表单中指定请求路径即可</li>
 * </ul>
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class HttpsServlet extends HttpServlet {
    /**
     * <p>通过调用无参数构造方法，创建对象</p>
     * <p>如果你要是同时重写了doGet和doPost，那还不如你直接重写service方法好了</p>
     */
    public HttpsServlet() {
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.service(request, response);
        // 响应一些内容到浏览器上
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>From Servlet</h1>");
    }

    /**
     * <p>{@link HttpServlet}是典型的模板类</p>
     * <p>{@link HttpServlet#service(HttpServletRequest, HttpServletResponse)}是一个模板方法</p>
     * <p>在该方法中定义核心算法骨架，具体的实现步骤延迟到子类中去完成</p>
     * <p>我们编写的HelloServlet直接继承HttpServlet，直接重写HttpServlet类中的service()方法</p>
     * <p>导致：享受不到405错误。享受不到HTTP协议专属的东西</p>
     */
    public void httpsService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求方式，可能是七种之一：
        // GET POST PUT DELETE HEAD OPTIONS TRACE
        String method = request.getMethod();

        // METHOD_GET: 返回"GET"
        // 如果请求方式是GET请求，则执行doGet方法
        if (method.equals("GET")) {
            // 如果请求方式是GET请求，则执行doGet方法
            doGet(request, response);
        } else if (method.equals("POST")) {
            // 如果请求方式是PST请求，则执行doPost方法
            doPost(request, response);
        }
    }

    /**
     * <p>当前端发送的请求是get请求的时候，要重写doGet方法</p>
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 响应一些内容到浏览器上
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>From Get Servlet</h1>");
    }

    /**
     * <p>当前端发送的请求是post请求的时候，要重写doPost方法</p>
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 响应一些内容到浏览器上
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>From Post Servlet</h1>");
    }
}
