package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.util.JDBCUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class InsertHeadle {

    public static boolean registerUser(HttpServletRequest request, HttpServletResponse response){
        boolean result=false;

        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try{
            connection= JDBCUtil.getConnection();
            String sql="insert into t_person values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            String persinId= UUID.randomUUID().toString();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,persinId);
            String a=request.getParameter("fullname");
            String b=request.getParameter("personname");
            preparedStatement.setString(2,request.getParameter("personname"));
            preparedStatement.setString(3,request.getParameter("personid"));
            preparedStatement.setString(4,request.getParameter("sex"));
            if (!"".equalsIgnoreCase(request.getParameter("age"))||request.getParameter("age").length()>0){
                preparedStatement.setInt(5,Integer.valueOf(request.getParameter("age")));
            }else{
                preparedStatement.setInt(5,0);
            }
            preparedStatement.setString(6,request.getParameter("fullname"));
            preparedStatement.setString(7,request.getParameter("native"));
            preparedStatement.setString(8,request.getParameter("emaill"));
            preparedStatement.setString(9,request.getParameter("passworld"));
            preparedStatement.setString(10,request.getParameter("birth"));
            preparedStatement.setString(11,request.getParameter("positionId"));
            preparedStatement.setString(12,request.getParameter("remarks"));
            preparedStatement.setString(13,"");
            java.sql.Date date=new java.sql.Date((new java.util.Date().getTime()));
            preparedStatement.setDate(14,date);
            preparedStatement.setString(15,"");
            preparedStatement.setDate(16,null);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try{
                    preparedStatement.close();
                    if (connection!=null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
