package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;
import com.rbac.studengrbac.model.Role;
import com.rbac.studengrbac.util.JDBCUtil;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/7/22.
 */
public class AllocationHandle {

    public static HttpServletRequest allocation(HttpServletRequest request){
        Connection connection=null;
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM T_PERSON ");
            ArrayList<Person> persons=new ArrayList<>();
            while (resultSet.next()==true){
                Person person=new Person(resultSet.getString("id"),resultSet.getString("fullname"));
                persons.add(person);
            }

            ResultSet re=statement.executeQuery("select * from t_role");
            ArrayList<Role> roles=new ArrayList<>();
            while (re.next()==true){
                Role role=new Role(re.getString("id"),re.getString("rolename"),re.getString("fullname"));
                roles.add(role);
            }
            request.setAttribute("persons",persons);
            request.setAttribute("roles",roles);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return request;
    }

    public static HttpServletRequest roleAllactionPower(HttpServletRequest request){
        Connection connection=null;
        Statement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from t_role");
            ArrayList<Role> roleArrayList=new ArrayList<>();
            while (resultSet.next()==true){
                Role role=new Role(resultSet.getString("id"),resultSet.getString("rolename"),resultSet.getString("fullname"));
                roleArrayList.add(role);
            }
            ResultSet re=statement.executeQuery("SELECT t.id,\n" +
                    "       nvl(t1.fullname, t3.fullname) as fullname,\n" +
                    "       nvl(t1.name,t3.name) as name,\n" +
                    "       nvl(t1.url,t3.INTERCEPURL) as url\n" +
                    "  FROM T_POWER t\n" +
                    "  left join T_MENU_CON_POWER tt\n" +
                    "    on t.id = tt.powerid\n" +
                    "  left join T_MENU_POWER t1\n" +
                    "    on t1.id = tt.menuid\n" +
                    "  left join T_OPERATION_CON_POWER t2\n" +
                    "    on t2.powerid = t.id\n" +
                    "  left join T_OPERATION_POWER t3\n" +
                    "    on t3.id = t2.opid\n");
            ArrayList<Power> powerArrayList=new ArrayList<>();
            while (re.next()==true){
                Power power=new Power(re.getString("id"),re.getString("fullname"),re.getString("name"),re.getString("url"));
                powerArrayList.add(power);
            }
            request.setAttribute("roleArrayList",roleArrayList);
            request.setAttribute("powerArrayList",powerArrayList);
            connection.close();
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
        return request;
    }

    public static void allocationRole(HttpServletRequest request){
        Connection connection=null;
        Statement statement=null;

        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            String roleid=request.getParameter("roleid");//循环
            String personid=request.getParameter("personid");
            String[] strings=roleid.split(",");
            for (int i=0;i<strings.length;i++){
                statement.execute("insert into t_role_connect_person values('"+strings[i]+"','"+personid+"');");
            }
            connection.commit();
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
    }

    public static void alloctionPower(HttpServletRequest request){

        Connection connection=null;
        Statement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            String roleid=request.getParameter("roleid");
            String[] strings=roleid.split(",");
            String powerid=request.getParameter("powerid");
            for (int i=0;i<strings.length;i++){
                statement.execute("insert into t_role_connect_power values('"+strings[i]+"','"+powerid+"');");
            }
            connection.commit();
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
    }
}
