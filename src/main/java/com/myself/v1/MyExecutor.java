package com.myself.v1;


import com.myself.v1.mapper.User;

import java.sql.*;

public class MyExecutor {

    public <T> T query(String sql, Object param) {
        Connection conn = null;
        Statement stmt = null;
        User user = new User();

        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moli", "root", "123456");

            // 执行查询
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format(sql, param));

            // 获取结果集
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                user.setId(id);
                user.setMobile(mobile);
                user.setName(name);
            }
            System.out.println("user:" + user);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) user;
    }
}
