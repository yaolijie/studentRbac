package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.LendHendle;
import com.rbac.studengrbac.model.Person;
import com.rbac.studengrbac.model.Power;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/7/11.
 */
public class MenuServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        String t=request.getParameter("t");
        if ("menulist".equalsIgnoreCase(t)){
            HttpSession session=request.getSession();

            Person person=(Person) session.getAttribute("person");
            String name = person.getPersonName();
            //查询出用户的菜单
            List<Power> list=LendHendle.getPower(name,"menu");
            request.setAttribute("menus",list);
            request.setAttribute("listPower",list);
            request.getRequestDispatcher("/view/menu/menuList.jsp").forward(request,response);
        }
    }
}
