package com.rbac.studengrbac.InitalData;

import com.rbac.studengrbac.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2019/6/5.
 */
public class InitaLHendle {

    public static void cretaeTable(){
        Connection connection=null;
        Statement statement=null;
        try{
            connection= JDBCUtil.getConnection();
            statement=connection.createStatement();
            String createSql="create table t_role(\n" +
                    "  id varchar(64) primary key not null,\n" +
                    "  rolename varchar(32),\n" +
                    "  code varchar(12),\n" +
                    "  stardate date,\n" +
                    "  enddate date,\n" +
                    "  remarks varchar(128),\n" +
                    "  createname varchar(32),\n" +
                    "  createtime date,\n" +
                    "  updatename varchar(32),\n" +
                    "  updatetime date\n" +
                    "\n" +
                    ");\n" +
                    "\n" +
                    "create table t_person(\n" +
                    "  id varchar(64) primary key not null,\n" +
                    "  personname varchar(64),\n" +
                    "  personid varchar(18),\n" +
                    "  sex varchar(2),\n" +
                    "  age int,\n" +
                    "  fullname varchar(44),\n" +
                    "  native varchar(10),\n" +
                    "  emaill varchar(20),\n" +
                    "  passworld varchar(12),\n" +
                    "  birth varchar(12),\n" +
                    "  positionId varchar(64),--出生地\n" +
                    "  remarks varchar(256),\n" +
                    "  createname varchar(32),\n" +
                    "  createtime date,\n" +
                    "  updatename varchar(32),\n" +
                    "  updatetime date\n" +
                    "\n" +
                    ");\n" +
                    "\n" +
                    "create table t_role_connect_person (\n" +
                    "  roleid varchar(64),\n" +
                    "  person varchar(64),\n" +
                    "\n" +
                    ");\n" +
                    "\n" +
                    "create table t_organ (\n" +
                    "  id varchar(64) primary key not null,\n" +
                    "  organname varchar(128),\n" +
                    "  type varchar(10),--机构是属于机构，还是部门\n" +
                    "  code varchar(10),\n" +
                    "  parentid varchar(64),\n" +
                    "  address varchar(526),\n" +
                    "  phone varchar(11),\n" +
                    "  remark varchar(526),\n" +
                    "  createname varchar(32),\n" +
                    "  createtime date ,\n" +
                    "  updatename varchar(32),\n" +
                    "  updatetime date\n" +
                    ");\n" +
                    "create table t_organ_connect_person (\n" +
                    "  organid varchar(64) primary key not null,\n" +
                    "  personId varchar(64)\n" +
                    ");";
            statement.execute(createSql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement!=null){
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

    public static void insertData(){

    }
}