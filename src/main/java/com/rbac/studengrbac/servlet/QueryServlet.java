package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.QueryHeadle;
import com.rbac.studengrbac.model.Organ;

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
        String t =request.getParameter("t");
        if ("queryOrgan".equalsIgnoreCase(t)){
            List<Organ> list= QueryHeadle.queryOrgan();
            request.setAttribute("orglist",list);
            request.getRequestDispatcher("/view/query/queryOrgan.jsp").forward(request,response);
        }
    }
}
