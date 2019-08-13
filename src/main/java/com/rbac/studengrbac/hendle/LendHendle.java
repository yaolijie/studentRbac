package com.rbac.studengrbac.hendle;

import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;
import com.rbac.studengrbac.util.JDBCUtil;
import com.sun.corba.se.spi.ior.IdentifiableBase;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public class LendHendle {

    public static Person lend(HttpServletRequest request, HttpServletResponse response){
        Connection connection=null;
        Statement statement=null;
        Person person=new Person();
        try{
            connection= JDBCUtil.getConnection();
            statement=connection.createStatement();
            Cookie[] cookies=request.getCookies();
            System.out.println("第一次登陆用户，查询数据库");
            String name=request.getParameter("username");
            String password=request.getParameter("passworld");
            System.out.println("用户信息:name"+name+"    \npassword :"+password);
            String sql="select * from t_person t where t.personname='"+name+"' and t.passworld='"+password+"';";
            ResultSet resultSet=statement.executeQuery(sql);
            if (resultSet.next()==true){
                //可以在前台加入是否记录密码
               // response.getWriter().append(request.getParameter(""));
                if (request.getParameter("save")!=null){
                    response.getWriter().append(request.getParameter("save"));
                    Cookie cookie=new Cookie("personName",request.getParameter("username"));
                    cookie.setPath("/");//保证cookie存放的根目录
                    //设置cookie存活时间为1天
                    cookie.setMaxAge(60*60*24);
                    //将cooki保存在客户端
                    response.addCookie(cookie);
                    person.setPersonName(name);
                    person.setPassworld(password);
                }else{//没有勾选保存密码
                    Cookie cookie=new Cookie("personName",request.getParameter("personname"));
                    cookie.setMaxAge(19);//设置cookie存活时间19s
                    //将cookie保存在客户端
                    response.addCookie(cookie);
                    person.setPersonName(name);
                    person.setPassworld(password);
                }
                System.out.println("cookie设置成功登陆系统");
            }else{
            }
        } catch (SQLException e) {
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (IOException e) {
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return person;
    }

    public static List<Power> getPower(String id){
        List<Power> powers=new ArrayList<>();
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            String sql="SELECT T.ID,T.TYPE,NVL(T1.FULLNAME,T3.FULLNAME)  AS NAME,NVL(T1.INTERCEPURL ,T3.URL) AS URL FROM T_POWER  T \n" +
                    "LEFT JOIN T_OPERATION_CON_POWER  TT ON TT.POWERID =T.ID\n" +
                    "LEFT JOIN T_OPERATION_POWER  T1 ON T1.ID=TT.OPID \n" +
                    "LEFT JOIN T_MENU_CON_POWER  T2 ON T2.POWERID =T.ID\n" +
                    "LEFT JOIN T_MENU_POWER  T3 ON T3.ID=T2.MENUID \n" +
                    "LEFT JOIN T_ROLE_CONNECT_POWER  R ON R.POWERID =T.ID\n" +
                    "LEFT JOIN T_ROLE  RR ON RR.ID=R.ROLEID\n" +
                    "LEFT JOIN T_ROLE_CONNECT_PERSON  P ON P.ROLEID =RR.ID\n" +
                    "LEFT JOIN T_PERSON  PP ON PP.ID=P.PERSON \n" +
                    "WHERE 1=1\n" +
                    "AND PP.ID IS NOT NULL \n" +
                    "AND PP.ID =?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()==true){
                Power power=new Power();
                power.setId(resultSet.getString("ID"));
                power.setFullName(resultSet.getString("NAME"));
                power.setUrl(resultSet.getString("URL"));
                powers.add(power);
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
        return powers;
    }
}
