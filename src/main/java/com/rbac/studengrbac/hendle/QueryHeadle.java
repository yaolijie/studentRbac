package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.model.Organ;
import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.util.JDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
