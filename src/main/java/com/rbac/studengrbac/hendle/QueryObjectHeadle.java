package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.model.Organ;
import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;
import com.rbac.studengrbac.model.Role;
import com.rbac.studengrbac.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryObjectHeadle {

    public static Power queryPower(String id,String type){

        Power power=new Power();
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            if ("menu".equalsIgnoreCase(type)){
                statement=connection.prepareStatement("select t.*,t2.type FROM T_MENU_POWER  t left join T_MENU_CON_POWER  t1 on t.id=t1.menuid \n" +
                        "left join t_power t2 on t2.id=t1.powerid  where t.id =?");
                statement.setString(1,id);
                ResultSet resultSet=statement.executeQuery();
                while (resultSet.next()==true){
                    power.setId(id);
                    power.setType(resultSet.getString("type"));
                    power.setName(resultSet.getString("name"));
                    power.setFullName(resultSet.getString("fullname"));
                    power.setCode(resultSet.getString("code"));
                    power.setUrl(resultSet.getString("url"));
                }
            }else{
                statement=connection.prepareStatement("select t.*,t2.type from T_OPERATION_POWER t left join T_OPERATION_CON_POWER t1 on t.id=t1.opid\n" +
                        "left join t_power t2 on t2.id=t1.powerid  where t.id =?");
                statement.setString(1,id);
                ResultSet resultSet=statement.executeQuery();
                while (resultSet.next()==true){
                    power.setId(id);
                    power.setType(resultSet.getString("type"));
                    power.setName(resultSet.getString("name"));
                    power.setFullName(resultSet.getString("fullname"));
                    power.setCode(resultSet.getString("code"));
                    power.setUrl(resultSet.getString("intercepUrl"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return power;
    }

    public static Person queryPerson(String id){
        Person person=new Person();
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            String sql="select t.*,t2.organname,t2.type from t_person t left join T_ORGAN_CONNECT_PERSON  t1\n" +
                    "on t.id=t1.personid left join t_organ t2 on t1.organid=t2.id where t.id=?";
            connection=JDBCUtil.getConnection();
            statement=connection.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()==true){
                person.setId(id);
                person.setPersonName(resultSet.getString("personname"));
                person.setSex(resultSet.getString("sex"));
                person.setAge(resultSet.getInt("age"));
                person.setFullName(resultSet.getString("fullname"));
                person.setNative0(resultSet.getString("native"));
                person.setEmaill(resultSet.getString("email"));
                person.setBirth(resultSet.getString("birth"));
                person.setRemarks(resultSet.getString("remarks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return person;
    }

    public static Organ queryOrgan(String id){
        Organ organ=new Organ();
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            String sql="select  * from t_organ where t=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()==true){
                organ.setId(id);
                organ.setOrganName(resultSet.getString("organname"));
                organ.setType(resultSet.getString("type"));
                organ.setCode(resultSet.getString("code"));
                organ.setAddress(resultSet.getString("address"));
                organ.setParentId(resultSet.getString("phone"));
                organ.setRemark(resultSet.getString("remark"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try{
                    statement.close();
                    if (connection!=null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return organ;
    }

    public static Role queryRole(String id){
        Role role=new Role();

        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            String sql="select * from t_role where id=? ";
            statement=connection.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()==true){
                role.setId(id);
                role.setRoleName(resultSet.getString("rolename"));
                role.setName(resultSet.getString("fullname"));
                role.setCode(resultSet.getString("code"));
                role.setStarDate(resultSet.getDate("stardate"));
                role.setEndDate(resultSet.getDate("enddate"));
                role.setRemarks(resultSet.getString("remarks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
}
