package com.rbac.studengrbac.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogRecord;

public class CheckLoginFilter implements Filter {

    private List<String> needCheckURIs;

    public void init(FilterConfig filterConfig) throws ServletException{

        String needCheclURI=filterConfig.getInitParameter("needCheckURI");
        String[] split=needCheclURI.split(",");
        needCheckURIs=Arrays.asList(split);

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws IOException,ServletException{
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        //获取当前请求的资源名
        String requestURL=httpServletRequest.getRequestURI();
        //如果当前请求的资源部需要校验的直接放行
        if (!needCheckURIs.contains(requestURL)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        //如果需要校验，判断用户是否登陆，是，则放行；反之回到登陆页
        Object person=httpServletRequest.getSession().getAttribute("person");
        if (person==null){
            httpServletResponse.sendRedirect("");
            return;
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    public void destroy() {

    }

}
