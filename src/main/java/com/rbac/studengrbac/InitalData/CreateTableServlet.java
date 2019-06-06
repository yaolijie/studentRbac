package com.rbac.studengrbac.InitalData;

import javax.servlet.http.HttpServlet;

/**
 * Created by Administrator on 2019/6/5.
 */
public class CreateTableServlet extends HttpServlet {

    @Override
    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
    String method=request.getParameter("t");
        if ("createTable".equalsIgnoreCase(method)){
            createtable();
        }else if("insertData".equalsIgnoreCase(method)){
            insertData();
        }
    }

    public void createtable(){
        InitaLHendle.cretaeTable();
    }

    public void insertData(){
        InitaLHendle.insertData();
    }
}
