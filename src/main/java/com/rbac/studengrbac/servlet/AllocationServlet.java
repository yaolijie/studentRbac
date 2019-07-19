package com.rbac.studengrbac.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/7/19.
 */
public class AllocationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{

        String t=request.getParameter("t");
        if ("allocationPower".equalsIgnoreCase(t)){
            request.getRequestDispatcher("/view/allocation/RoleAllocationPower.jsp").forward(request,response);
        }if ("allocationRole".equalsIgnoreCase(t)){
            request.getRequestDispatcher("/view/allocation/PersonAllocationRole.jsp").forward(request,response);
        }
    }
}
