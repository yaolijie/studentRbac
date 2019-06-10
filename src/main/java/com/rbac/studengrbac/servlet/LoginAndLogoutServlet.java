package com.rbac.studengrbac.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAndLogoutServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String t=req.getParameter("t");
        if ("logout".equalsIgnoreCase(t)){
            logout(req,resp);
        }
    }

    public void logout(HttpServletRequest request,HttpServletResponse response){

        try{
            //删除登陆信息
      //      request.getSession().removeAttribute("person");
            //销毁sessiom
            request.getSession().invalidate();
             response.sendRedirect("/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
