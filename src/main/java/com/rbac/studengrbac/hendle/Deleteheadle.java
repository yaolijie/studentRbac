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
                statement.execute("delete from T_MENU_CON_POWER  t where t.powerid="+id);
                statement.execute("delete from t_role_connect_power p where p.powerid=(select  y.id  from T_POWER  y left join T_MENU_CON_POWER  x where x.MENUID = "+id+")");
            }else{
                statement.execute("delete from T_OPERATION_POWER  where id="+id);
                statement.execute("delete from T_OPERATION_CON_POWER  tt where tt.powerid="+id);
                statement.execute("delete from t_role_connect_power p where p.powerid=(select  y.id  from T_POWER  y left join T_OPERATION_CON_POWER x where x.OPID = "+id+")");
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
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_role t where t.id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            boolean result=preparedStatement.execute();
            statement.execute("delete from T_ROLE_CONNECT_PERSON  r where r.roleid="+id);
            statement.execute("delete from t_role_connect_power pow where pow.roleid=");
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
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_person t where t.id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            boolean result=preparedStatement.execute();
            statement.execute("delete from T_ORGAN_CONNECT_PERSON  t2 where t2.personid="+id);
            statement.execute("delete froom T_ROLE_CONNECT_PERSON  rr where rr.person="+id);
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
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="delete from t_organ t where t.id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            boolean result=preparedStatement.execute();
            statement.execute("delete from T_ORGAN_CONNECT_PERSON t1 where t1.organid="+id);
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
