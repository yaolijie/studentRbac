package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/6/21.
 */
public class Deleteheadle {

    public static void deletePower(String id){

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_power t where t.id=?";
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
