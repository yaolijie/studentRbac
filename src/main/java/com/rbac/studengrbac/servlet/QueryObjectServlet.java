package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.QueryObjectHeadle;
import com.rbac.studengrbac.model.Organ;
import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;
import com.rbac.studengrbac.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/7/3.
 */
public class QueryObjectServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String t=request.getParameter("t");

        if ("queryRole".equalsIgnoreCase(t)){
            Role role=QueryObjectHeadle.queryRole(request.getParameter("queryid"));
            request.setAttribute("role",role);
            request.getRequestDispatcher("view/queryObject/queryRoleObject.jsp").forward(request,response);
        }else if ("queryPower".equalsIgnoreCase(t)){
            Power power=QueryObjectHeadle.queryPower(request.getParameter("queryid"),request.getParameter("type"));
            request.setAttribute("power",power);
            request.getRequestDispatcher("view/queryObject/queryPowerObject.jsp").forward(request,response);
        }else if ("queryPerson".equalsIgnoreCase(t)){
            Person person=QueryObjectHeadle.queryPerson(request.getParameter("queryid"));
            request.setAttribute("person",person);
            request.getRequestDispatcher("view/queryObject/queryPersonObject.jsp").forward(request,response);
        }else if ("queryOrgan".equalsIgnoreCase(t)){
            Organ organ=QueryObjectHeadle.queryOrgan(request.getParameter("queryid"));
            request.setAttribute("organ",organ);
            request.getRequestDispatcher("view/queryObject/queryOrganObject.jsp").forward(request,response);
        }
    }
}
