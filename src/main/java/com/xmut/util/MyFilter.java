package com.xmut.util;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
@WebFilter(filterName="myFilter",urlPatterns= {"/api/admin/*","/admin/*"})
public class MyFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest req=(HttpServletRequest)request;
    	HttpServletResponse reps=(HttpServletResponse)response;
    	HttpSession session = req.getSession();
        System.out.println("执行过滤操作");
        Object isLogin=session.getAttribute("isLogin");
        System.out.println(isLogin);
        if(isLogin!=null&&((int)isLogin)==1)
        {
        	System.out.println("已登陆");
        	chain.doFilter(request, response);
        }
        else {
        	if(req.getHeader("Accept").indexOf("text/html")!=-1)
        	{
        		reps.setStatus(1024);
        	}
        	System.out.println(reps.getStatus());
        	req.getRequestDispatcher("/error").forward(req, reps);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}