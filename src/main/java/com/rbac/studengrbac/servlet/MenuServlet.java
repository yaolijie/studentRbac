package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.model.Power;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
public class MenuServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        String t=request.getParameter("t");
        if ("menulist".equalsIgnoreCase(t)){

            List<Power> list=new ArrayList<>();
            list.add(new Power("用户信息","/QueryServlet?t=queryPerson"));
            list.add(new Power("机构信息","/QueryServlet?t=queryOrgan"));
            request.setAttribute("listPower",list);
            request.getRequestDispatcher("/view/menu/menuList.jsp").forward(request,response);
        }
    }
}
