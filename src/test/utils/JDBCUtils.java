package test.utils;

import test.entity.User;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class JDBCUtils {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test1?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "520520";


    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public  void getConnection() {
        try {
            // 加载数据库驱动
            Class.forName(DRIVER);
            // 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql, Object... obj) {
        int num = 0;
        getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pstmt.setObject(i + 1, obj[i]);
            }
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return num;
    }


    public ResultSet executeQuery(String sql, Object... obj) {
        getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pstmt.setObject(i + 1, obj[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    public void closeAll() {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
