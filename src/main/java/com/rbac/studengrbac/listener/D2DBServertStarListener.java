package com.rbac.studengrbac.listener;

import org.h2.tools.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/6/5.
 */

public class D2DBServertStarListener implements ServletContextListener {

    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try{
            System.out.println("正在启动h2 数据库。。。。。。。");
            server= Server.createTcpServer().start();
            System.out.println("h2 数据库启动成功。。。。。。。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("管理关闭h2数据");
        if (this.server!=null){
            System.out.println("h2数据库启动成功！");
            this.server.stop();
            this.server=null;
        }
    }
}
