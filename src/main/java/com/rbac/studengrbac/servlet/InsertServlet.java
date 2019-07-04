package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.InsertHeadle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //InsertServlet?t=insertRole
        String t=request.getParameter("t");
        if ("insertRole".equalsIgnoreCase(t)) {
            InsertHeadle.insertRole(request);
        }else if ("insertOrgan".equalsIgnoreCase(t)){
            InsertHeadle.insertOrgan(request);
        }else if ("insertPower".equalsIgnoreCase(t)){
            InsertHeadle.insertPower(request);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //http://localhost:8080/studentRbac/InsertServlet?t=insertRoleJsp
        String t=request.getParameter("t");
        if ("insertRoleJsp".equalsIgnoreCase(t)){
            request.getRequestDispatcher("/view/insert/insertRole.jsp").forward(request,response);
        }else if ("insertOrganJsp".equalsIgnoreCase(t)){
            request.getRequestDispatcher("/view/insert/insertOrgan.jsp").forward(request,response);
        } else if ("insertPowerJsp".equalsIgnoreCase(t)) {
            request.getRequestDispatcher("/view/insert/insertPower.jsp").forward(request,response);
        }else if("insertPersonJsp".equalsIgnoreCase(t)){
            request.getRequestDispatcher("/view/insert/insertPerson.jsp").forward(request,response);
        }
    }
    @Override
    public void destroy() {
        super.destroy();
    }
}
