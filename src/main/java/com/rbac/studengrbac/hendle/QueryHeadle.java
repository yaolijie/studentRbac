package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.model.Organ;
import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;
import com.rbac.studengrbac.model.Role;
import com.rbac.studengrbac.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryHeadle
{
    public static Person queryAdmin()
    {
        Connection connection = null;
        Statement statement = null;
        Person person = new Person();
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from t_person t where t.personname='admin'");
            while (resultSet.next() == true) {
                String name = resultSet.getString("personname");
                person.setPersonName(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static List<Organ> queryOrgan() {
        List<Organ> list = new ArrayList();
        String sql = "select * from t_organ t";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next() == true) {
                Organ organ = new Organ();
                organ.setId(resultSet.getString("id"));
                organ.setOrganName(resultSet.getString("organname"));
                organ.setCode(resultSet.getString("code"));
                organ.setAddress(resultSet.getString("address"));
                organ.setPhone(resultSet.getString("phone"));
                organ.setRemark(resultSet.getString("remark"));
                list.add(organ);
            }
            connection.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
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
        return list;
    }

    public static List<Person> queryPerson(){
        List<Person> persons=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection= JDBCUtil.getConnection();
            preparedStatement=connection.prepareStatement("select * from t_person t");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Person person=new Person();
                person.setId(resultSet.getString("id"));
                person.setPersonName(resultSet.getString("personname"));
                person.setPersonId(resultSet.getString("personid"));
                person.setSex(resultSet.getString("sex"));
                person.setAge(resultSet.getInt("age"));
                person.setFullName(resultSet.getString("fullname"));
                person.setNative0(resultSet.getString("native"));
                person.setBirth(resultSet.getString("birth"));
                person.setPositionId(resultSet.getString("positionId"));
                person.setEmaill(resultSet.getString("emaill"));
                person.setRemarks(resultSet.getString("remarks"));
                persons.add(person);
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try{
                    preparedStatement.close();;
                    if (connection!=null)
                        connection.close();
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return persons;
    }

    public static List<Role> queryRole(){
        List<Role> list=new ArrayList<>();
        Connection connection=null;
        Statement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            String sql="select * from t_role t";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Role role=new Role();
                role.setId(resultSet.getString("id"));
                role.setRoleName(resultSet.getString("rolename"));
                role.setName(resultSet.getString("fullname"));
                role.setCode(resultSet.getString("code"));
                role.setStarDate(resultSet.getDate("stardate"));
                role.setEndDate(resultSet.getDate("enddate"));
                role.setRemarks(resultSet.getString("remarks"));
                list.add(role);
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try{
                    statement.close();
                    if (connection!=null){
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public static List<Power> queryPower(){
        List<Power> list=new ArrayList<>();
        Connection connection=null;
        Statement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            String sql="select * from t_power t";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Power power=new Power();
                power.setId(resultSet.getString("id"));
                power.setType(resultSet.getString("type"));
                power.setCode(resultSet.getString("code"));
                power.setName(resultSet.getString("name"));
                power.setFullName(resultSet.getString("fullname"));
                power.setIntercepUrl(resultSet.getString("url"));
                list.add(power);
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
        return list;
    }
}
