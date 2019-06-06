package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.InsertHeadle;
import com.rbac.studengrbac.hendle.LendHendle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class lendServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        String method =request.getParameter("t");

        if ("register".equalsIgnoreCase(method)){
            registerUser(request,response);
        }else if ("lend".equalsIgnoreCase(method)){
            lend(request,response);
        }
    }

    public void registerUser(HttpServletRequest request, HttpServletResponse response){

        InsertHeadle.registerUser(request,response);
    }

    public void lend(HttpServletRequest request,HttpServletResponse response){

        LendHendle.lend(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        lend(request,response);
    }
}
