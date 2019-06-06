package com.rbac.studengrbac.InitalData;

import com.rbac.studengrbac.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2019/6/5.
 */
public class CreateFunctionServlet extends HttpServlet {

    private String uuid= UUID.randomUUID().toString();

    public String getUuid() {
        return uuid;
    }

    private Date sysDate=new Date();

    public Date getSysDate() {
        return sysDate;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        Connection connection=null;
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            statement=connection.createStatement();
            String sql="create alias if not exists uuid from 'com.rbac.studengrbac.InitalData.CreateFunctionServlet.getUuid'";
            String datesql="create alias if not exists sysDate from 'com.rbac.studengrbac.InitalData.CreateFunctionServlet.getSysDate'";
            statement.execute(datesql);
            statement.equals(sql);
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try{
                    statement.close();
                    if (connection!=null)
                        connection.close();
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
