package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.util.JDBCUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2019/6/5.
 */
public class LendHendle {

    public static void lend(HttpServletRequest request, HttpServletResponse response){

        Connection connection=null;
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
