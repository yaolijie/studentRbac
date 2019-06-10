package com.rbac.studengrbac.util;

import java.sql.*;

public class JDBCUtil {

    private static Connection connection=null;

    private static Statement statement=null;

    private static PreparedStatement preparedStatement=null;
    static {
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

//    public static Statement getStatement() {
//        try{
//            statement=connection.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return statement;
//    }
//
//    public static PreparedStatement getPreparedStatement(String sql) {
//        try{
//            preparedStatement=connection.prepareStatement(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return preparedStatement;
//    }
}
