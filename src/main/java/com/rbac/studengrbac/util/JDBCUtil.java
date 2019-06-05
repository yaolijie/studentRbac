package com.rbac.studengrbac.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static Connection connection=null;
    {
        try{
            Class.forName("org.h2.Driver");
            connection=DriverManager.getConnection("jdbc:h2:~/test","sa","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
