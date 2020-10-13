package com.example.clocky_user.model;

import lombok.ToString;
import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private Connection getConnection() throws SQLException{
        Connection conn = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://clocky.c1f0skt2wmdj.ap-northeast-2.rds.amazonaws.com:3306";
            conn = DriverManager.getConnection(url,"test", "test");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("로딩실패");
        }

        return conn;
    }

    public boolean insert(UserVO vo){
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = getConnection();
            String sql = "INSERT INTO name_test VALUES(null, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getName());
            pstmt.setString(2, Integer.toString(vo.getPassword()));

            int count = pstmt.executeUpdate();

            result = (count==1);

        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(conn!=null)
                    conn.close();
                if(pstmt!=null)
                    conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
