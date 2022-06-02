package general;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;

public class DatabaseConnectivity {


    public static Connection dbConnection(String host, String user, String password) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(host, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;

    }




}
