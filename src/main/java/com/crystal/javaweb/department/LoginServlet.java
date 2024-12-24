package com.crystal.javaweb.department;

import com.crystal.javaweb.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //
        boolean isSuccess = false;
        // 获取应用的跟
        String contextPath = request.getContextPath();

        // 连接数据库验证用户名和密码
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtil.getConnection();
            // 编写sql语句
            String sql = "select * from user where username = ? and password = ?";
            ps = connection.prepareStatement(sql);
            // 给?传值
            ps.setString(1, username);
            ps.setString(2, password);
            // 返回结果集
            rs = ps.executeQuery();
            // 这个结果当中最多只有一条数据
            if (rs.next()) {
                // 用户密码时正确的
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, ps, rs);
        }

        // 登录成功/登录失败
        if (isSuccess) {
            response.sendRedirect(contextPath + "/index.jsp");
        } else {
            response.sendRedirect(contextPath + "/error.html");
        }

    }
}
