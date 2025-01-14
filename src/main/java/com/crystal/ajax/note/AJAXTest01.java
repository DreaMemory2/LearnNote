package com.crystal.ajax.note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/test01")
public class AJAXTest01 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /* Servlet向浏览器响应一段数据 */
        PrintWriter out = response.getWriter();

        // out对象向浏览器输出信息
        // 只是这个out响应时，浏览器客户端XMLRequest对象会接收到响应的信息
        out.print("<h3>Get请求发生成功</h3>");
    }
}
