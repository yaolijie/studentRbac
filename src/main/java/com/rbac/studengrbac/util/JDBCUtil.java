package com.rbac.studengrbac.util;

import java.sql.*;

public class JDBCUtil {

    private static Connection connection=null;

    private static Statement statement=null;

    private static PreparedStatement preparedStatement=null;
//    static {
//        try{
//            Class.forName("org.h2.Driver");
//            System.out.println("数据库连接对象初始化");
//            connection=DriverManager.getConnection("jdbc:h2:~/test","sa","");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static Connection getConnection() {

        try{
            Class.forName("org.h2.Driver");
            System.out.println("数据库连接对象初始化");
            connection=DriverManager.getConnection("jdbc:h2:~/test","sa","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
