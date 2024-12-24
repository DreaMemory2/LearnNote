package com.crystal.javaweb.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class JDBCUtil {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("crystal.jdbc");
    private static final String DRIVER = BUNDLE.getString("driver");
    private static final String URL = BUNDLE.getString("url");
    private static final String USER = BUNDLE.getString("user");
    private static final String PASSWORD = BUNDLE.getString("password");

    static {
        // 注册驱动（注册驱动只需要注册一次）
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  <p>属性资源文件绑定</p>
     *  <p>根据属性配置文件key获取value</p>
     * {@return 获取数据库链接对象}
     */
    public static Connection getConnection() throws Exception {
        // 获取链接
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * <p>释放资源</p>
     * @param connection 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集对象
     */
    public static void close(Connection connection, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
