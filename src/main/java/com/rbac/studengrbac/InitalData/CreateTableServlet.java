package com.rbac.studengrbac.InitalData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/6/5.
 */
public class CreateTableServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

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
