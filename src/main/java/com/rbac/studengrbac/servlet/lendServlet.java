package com.rbac.studengrbac.servlet;

import com.rbac.studengrbac.hendle.InsertHeadle;
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

       // String code= (String) request.getParameter("code");
        HttpSession session=request.getSession();
        String randomCode=(String) session.getAttribute("randomCode");
       // if(randomCode.equalsIgnoreCase(code)){
            Person resule=LendHendle.lend(request,response);
            if (resule==null){
                try{
                    request.setAttribute("error","用户名或密码错误！");
                    request.getRequestDispatcher("/view/index.jsp").forward(request,response);
                }catch (IOException e) {
                    e.printStackTrace();
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }else{
                try{
                    request.getSession().setAttribute("person",resule);
                    response.sendRedirect("/studentRbac/view/frame/frame.html");
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
//        }else{
//            try{
//                request.setAttribute("error","验证码错误！");
//                request.getRequestDispatcher("/view/index.jsp").forward(request,response);
//            }
//            catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        String method =request.getParameter("t");
        if ("register".equalsIgnoreCase(method)){
            registerUser(request,response);
        }else if ("lend".equalsIgnoreCase(method)){
            lend(request,response);
        }
    }
}
