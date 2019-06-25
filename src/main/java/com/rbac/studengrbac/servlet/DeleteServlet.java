package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.Deleteheadle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/6/21.
 */
public class DeleteServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        String t=request.getParameter("t");
        if ("deleteRole".equalsIgnoreCase(t)){
            Deleteheadle.deleteRole(request.getParameter("id"));
        }else if ("deletePower".equalsIgnoreCase(t)){
            Deleteheadle.deletePower(request.getParameter("id"));
        }else if ("deletePerson".equalsIgnoreCase(t)){
            Deleteheadle.deletePerson(request.getParameter("id"));
        }else if ("deleteOrgan".equalsIgnoreCase(t)){
            Deleteheadle.deleteOrgan(request.getParameter("id"));
        }
    }

}
