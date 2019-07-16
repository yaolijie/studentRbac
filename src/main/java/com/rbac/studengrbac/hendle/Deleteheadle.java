package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2019/6/21.
 */
public class Deleteheadle {

    public static void deletePower(String id,String type){

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_power t where t.id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            boolean result=preparedStatement.execute();
            if ("menu".equalsIgnoreCase(type)){
                statement.execute("delete from T_MENU_POWER  t where t.id="+id);
            }else{
                statement.execute("delete from T_OPERATION_POWER  where id="+id);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try{
                    preparedStatement.close();
                    if (statement!=null)
                        statement.close();
                    if (connection!=null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteRole(String id){

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_role t where t.id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            boolean result=preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
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
    }

    public static void deletePerson(String id){

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_person t where t.id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            boolean result=preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
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
    }

    public static void deleteOrgan(String id){

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_organ t where t.id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            boolean result=preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
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
    }
}
