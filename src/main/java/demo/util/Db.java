package demo.util;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Created by 高伟冬 on 2017/6/10.
 * ip_1702
 * 10:27
 * 星期六
 */
public class Db {

    private static final String URL = "jdbc:mysql:///?user=root&password=password";

    public static Connection getConnection() {
        try {
            new Driver();
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
