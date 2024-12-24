package com.crystal.javaweb.department;

import com.crystal.javaweb.bean.Department;
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
import java.util.ArrayList;
import java.util.List;

/**
 * <p>1. 模板类</p>
 * <p>一个单标的CRUD，需要写更多Servlet，明显的类爆炸问题</p>
 * <p>使用模板方法设计模式可以解决：一个请求对应一个方法。一个业务对应一个Servlet类</p>
 * <p>处理部门相关业务的对应一个DeptServlet。处理用户相关业务的对应一个UserServlet</p>
 * <p>2. 模糊匹配</p>
 * <p>只要请求路径为"/department"开始的，都走这个Servlet类</p>
 * @author Crystal
 * @version 3.0
 * @since 1.0
 */
@WebServlet("/department/*")
public class DepartmentServlet extends HttpServlet {
    /**
     * <p>准备一个容器，用来专门存储部门</p>
     */
    private static final List<Department> DEPARTMENTS = new ArrayList<>();
    /**
     * <p>模板方法</p>
     * <p>重写service方法，并没有重写doGet方法和doPost方法</p>
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getRequestURI()) {
            case "/servlet/department/list" -> doList(request, response);
            case "/servlet/department/check" -> doDetail(request, response);
            case "/servlet/department/delete" -> doDeletes(request, response);
            case "/servlet/department/save" -> doSave(request, response);
            case "/servlet/department/modify" -> doModify(request, response);
        }
    }

    /**
     * <p>根据部门编号删除部门</p>
     */
    private void doDeletes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取部门编号
        String number = request.getParameter("number");
        // 获取web项目名字
        String contextPath = request.getContextPath();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int count = 0;
        try {
            // 连接数据库，删除部门
            connection = JDBCUtil.getConnection();
            String sql = "delete from department where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, number);
            count = ps.executeUpdate();
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, ps, rs);
        }
        if (count == 1) {
            log("删除成功");
            // 重定向到列表页面
            response.sendRedirect(contextPath + "/department/list");
        }
    }

    /**
     * <p>根据部门编号获取部门的信息</p>
     */
    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户提交的数据，获取部门编号
        String number = request.getParameter("number");

        // 根据部门编号获取部门信息，将部门信息封装成部门类对象
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Department department = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select name, location from department where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, number);
            rs = ps.executeQuery();

            // 这个结果集只有一条数据
            if (rs.next()) {
                String name = rs.getString("name");
                String location = rs.getString("location");

                department = new Department(Integer.valueOf(number), name, location);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, ps, rs);
        }
        // 并且查找的是一个Bean，并放置请求域当中
        /* 使用EL表达式获取数据 */
        request.setAttribute("department", department);
        // 转发两个页面处理
        String value = request.getParameter("value");
        if ("modify".equals(value)) {
            // 转发到修改页面
            request.getRequestDispatcher("/jsp/department-revise.jsp").forward(request, response);
        } else {
            // 转发到详情页面
            request.getRequestDispatcher("/jsp/department-check.jsp").forward(request, response);
        }
    }

    /**
     * <p>保存部门信息</p>
     */
    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 注意乱码问题
        request.setCharacterEncoding("UTF-8");
        // 获取部门信息
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        // 连接数据库执行insert语句
        Connection connection = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into department values(?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, number);
            ps.setString(2, name);
            ps.setString(3, location);
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, ps, null);
        }
        if (count == 1) {
            // 保存成功跳转列表页面

            // 使用重定向(浏览器会发一次全新的请求)
            // 浏览器在地址栏上发送请求，这个请求是get请求
            response.sendRedirect(request.getContextPath() + "/department/list");
        }
    }

    /**
     * <p>连接数据库，查询所有部门信息，将部门信息收集好，然后跳转到JSP做页面展示</p>
     * <p>第三次升级: 使用JSP改造oa项目</p>
     */
    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 连接数据库，查询所有的部门信息
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 获取链接资源
            connection = JDBCUtil.getConnection();
            // 执行查询语句，Sql语句
            String sql = "select id, name, location from department";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            // 遍历结果集
            while (rs.next()) {
                // 从结果集取出数据
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");

                // 将零散的数据封装成一个对象
                // 将部门对象放入集合当中
                DEPARTMENTS.add(new Department(id, name, location));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtil.close(connection, ps, rs);
        }

        // 将集合放入请求域当中
        request.setAttribute("department", DEPARTMENTS);

        // 转发
        request.getRequestDispatcher("/jsp/department.jsp").forward(request, response);
    }

    /**
     * <p>点击"修改"起效</p>
     * <p>修改部门</p>
     */
    private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取表单数据：部门编号，部门名称，部门地址
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        // 解决乱码问题
        request.setCharacterEncoding("UTF-8");
        // 连接数据库执行更新语句
        Connection connection = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "update department set name = ?, location = ? where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setString(3, number);
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, ps, null);
        }
        if (count == 1) {
            // 更新成功
            // 跳转到部门列表页面(部门列表页面是java程序动态生成，所以需要执行里另一个Servlet类)
            response.sendRedirect(request.getContextPath() + "/department/list");
        }
    }
}
