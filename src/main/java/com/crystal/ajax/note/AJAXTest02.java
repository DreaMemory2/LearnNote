package com.crystal.ajax.note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/test02")
public class AJAXTest02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* 获取AJAX获取get请求提交的数据 */
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            String parameter = request.getParameter(element);
            out.print("<p>" + element + ": " + parameter + "</p>");
        }
    }
}
