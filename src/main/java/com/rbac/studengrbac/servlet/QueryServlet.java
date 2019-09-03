package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.QueryHeadle;
import com.rbac.studengrbac.model.Organ;
import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;
import com.rbac.studengrbac.model.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/6/10.
 */
public class QueryServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        //QueryServlet?t=queryRole
        String t =request.getParameter("t");
        if ("queryOrgan".equalsIgnoreCase(t)){
            List<Organ> list= QueryHeadle.queryOrgan();
            request.setAttribute("orglist",list);
            response.sendRedirect("/studentRbac/view/query/queryOrgan.jsp");
           // request.getRequestDispatcher("/view/query/queryOrgan.jsp").forward(request,response);
        } else if ("queryPower".equalsIgnoreCase(t)) {
            List<Power> list= QueryHeadle.queryPower();
            request.setAttribute("listPower",list);
            response.sendRedirect("/studentRbac/view/query/queryPower.jsp");
           // request.getRequestDispatcher("/view/query/queryPower.jsp").forward(request,response);
        }else if ("queryRole".equalsIgnoreCase(t)){
            List<Role> list= QueryHeadle.queryRole();
            request.setAttribute("listRole",list);
            response.sendRedirect("/studentRbac/view/query/queryRole.jsp");
           // request.getRequestDispatcher("/view/query/queryRole.jsp").forward(request,response);
        }else if ("queryPerson".equalsIgnoreCase(t)){
            List<Person> list= QueryHeadle.queryPerson();
            request.setAttribute("list",list);
            response.sendRedirect("/studentRbac/view/query/queryPerson.jsp");
           // request.getRequestDispatcher("/view/query/queryPerson.jsp").forward(request,response);

        }
    }
}
