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
            String createSql=
                    "create table t_role(\n" +
                    "  id varchar(64) primary key not null,\n" +
                    "  rolename varchar(32),\n" +
                    "  fullname varchar(64),\n" +
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
                    "create table t_role_connect_person (\n" +
                    "  roleid varchar(64),\n" +
                    "  person varchar(64),\n" +
                    "\n" +
                    ");\n" +
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
                    ");\n" +
                    "\n" +
                    "create table t_power(\n" +
                    "    id varchaer(64) primary key not null,\n" +
                    "    type varchar(20),\n" +
                    "    createtime date;\n" +
                    ");\n" +
                    "create table t_operation_power{\n" +
                    "    id varchar(64) primary key not null,\n" +
                    "    name varchar(32),\n" +
                    "    fullname varchar (32),\n" +
                    "    code varchar(20),\n" +
                    "    intercepUrl varchar(256),\n" +
                    "    parentid varchar(64),\n" +
                    "    createTime date;\n" +
                    "};\n" +
                    "create table t_menu_power(\n" +
                    "    id varchar(64) primary key not null,\n" +
                    "    name varchar(64),\n" +
                    "    fullname varchar (32),\n" +
                    "    code varchar (64),\n" +
                    "    url varchar (128),\n" +
                    "    parentId varchar (64),\n" +
                    "    createtime date\n" +
                    ") ;\n" +
                    "create table t_menu_con_power(\n" +
                    "    powerid varchar (64),\n" +
                    "    menuid varchar (64);\n" +
                    ");";
            statement.execute(createSql);
            connection.commit();
        } catch (SQLException e) {
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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

        Connection connection=null;
        Statement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            statement=connection.createStatement();
            String sql="--插入角色\n" +
                    "insert into t_role values(uuid(),'manage','0',sysDate(),sysDate(),'','',sysDate(),'',sysDate());\n" +
                    "insert into t_role values(uuid(),'member','1',sysDate(),sysDate(),'','',sysDate(),'',sysDate());\n" +
                    "--机构\n" +
                    "insert into t_organ values(uuid(),'上航','1','00','','上海','1234','无','',sysDate(),'',sysDate());\n" +
                    "insert into t_organ values(uuid(),'杭航','1','00','','杭州','1234','无','',sysDate(),'',sysDate());\n" +
                    "insert into t_organ values(uuid(),'商务部','0','00','','上海','1234','无','',sysDate(),'',sysDate());";
            statement.execute(sql);
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
