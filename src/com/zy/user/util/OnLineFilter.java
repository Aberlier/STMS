package com.zy.user.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OnLineFilter implements Filter {
    //没有初始化参数所以init()方法直接空过
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //处理的是Http请求所以强转
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;  
        httpServletRequest.setCharacterEncoding("utf-8");
        //如果用户登录过，那么session中被会加上一个特定的标识属性
        HttpSession session = httpServletRequest.getSession();
		// 获得请求的URL
		String url = httpServletRequest.getRequestURL().toString();
		System.out.println(url);
		if (url.endsWith("regist.jsp")||url.endsWith("login.jsp") 
				||  url.endsWith(".css") 
				
				|| url.endsWith(".js") || url.endsWith(".gif")|| url.endsWith(".svg")
				
				|| url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith("404.jpg")
				
				|| url.endsWith("404index.jsp")|| url.endsWith("/loginServlet")||  url.endsWith("/registServlet")  || url.endsWith("/VerifyCodeServlet")) {
 
			chain.doFilter(request, response);
 
		}else{
			//看看是否能查找到这个属性	        
	        String role = (String) session.getAttribute("role");
	        System.out.println(role);
	        //如果没找到说明这个访问者没有登录过这个网页
	        if(role == null){
	            //直接请求转发到一个写好的错误页面上，尽量保持地址栏的URL不变
	        	/*String failurl=((HttpServletRequest) request).getContextPath()+"/login.jsp";
	    		String msg = "<script>alert('登录超时失败，请退出重新登录！');window.location.href='"+failurl+"';</script>";
	    		request.setAttribute("msg", msg);
	    		request.getRequestDispatcher("msg.jsp").forward(request, response);	*/
	        	String failurl=httpServletRequest.getContextPath()+ "/login.jsp";
	        	String msg = "<script>alert('登录超时失败，请退出重新登录！');window.parent.location.href='"+failurl+"';</script>";
	        	request.setAttribute("msg", msg);
	    		request.getRequestDispatcher("/msg.jsp").forward(request, response);	
	        	/*session.setAttribute("msg", "登陆超时，请退出重新登录！");
	        	httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+ "/login.jsp");*/
	            return;

	        }else {
	        	chain.doFilter(request, response);
			}
		}
       
        
    }
    @Override
    //这个Filter只是用来检测Session属性的，destroy()方法也空过
    public void destroy() {}
}

