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
@WebServlet("/test03")
public class AJAXTest03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<h3>Hello World</h3>");

        /* 获取数据 */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        out.print("<p>username: " + username +"</p>");
        out.print("<p>password: " + password +"</p>");
    }
}
