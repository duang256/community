package cn.wit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.User;

@WebFilter(urlPatterns = {"*.do"})
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        System.out.println(uri);
		if(uri.indexOf("validateCode.do") != -1 || uri.indexOf("login.do") != -1 || uri.indexOf("adminLogin.do") != -1 || uri.indexOf("userRegister.do") != -1){
			chain.doFilter(req, resp);
			return;
		}
		String status = (String) session.getAttribute("login");
		
		
		if(status.equals("yes")) chain.doFilter(req, resp);
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
