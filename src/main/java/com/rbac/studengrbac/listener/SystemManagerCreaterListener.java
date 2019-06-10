package com.rbac.studengrbac.listener;

import com.rbac.studengrbac.hendle.InsertHeadle;
import com.rbac.studengrbac.hendle.QueryHeadle;
import com.rbac.studengrbac.model.Person;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SystemManagerCreaterListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //查询系统默认账户是否存在，如果不存在，创建一个默认账户
        //数据库查询是否有管理员用户

        Person person= QueryHeadle.queryAdmin();
        if (person==null){
            person=new Person();
            person.setPersonName("admin");
            person.setPassworld("admin");
            person.setFullName("admin");
            //保存如数据库
            InsertHeadle.insertAdmin(person);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {


    }
}
