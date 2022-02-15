package cn.wit.filter;

import java.io.IOException;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.wit.common.*;
import cn.wit.dao.UserLoginDao;
import cn.wit.daoImpl.UserLoginDaoImpl;
import cn.wit.exception.UserNotFoundException;;

/**
 * �жϵ�ǰ�ͻ���������Ƿ��¼��Filter
 */
@WebFilter(urlPatterns = {"*.do","*.jsp"})
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletRequest request = (HttpServletRequest)servletRequest;
    	HttpServletResponse resp = (HttpServletResponse)servletResponse;
    	UserLoginDao ld = new UserLoginDaoImpl();
    	
    	request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER_SESSION_KEY);
        
        if(uri.indexOf("login.jsp") != -1){
        	if(user!=null){
        		resp.sendRedirect("main.jsp");
        		return;
        	}
        	
        	Cookie[] cookies = request.getCookies();
            Cookie loginCookie=null;
            if(cookies!=null){
                 for (Cookie cookie : cookies) {
                     //��������ͷ�е�����cookie�Ƿ��а���"loginCookie"
                     if(cookie.getName().equals(Constants.USER_COOKIE)){
                         loginCookie=cookie;
                     }
                 }
            }
        	if(loginCookie != null){
        		System.out.println("��֤cookie��");
        		
        		try {
					//˵������ͷ�ϵ�cookie����Я����¼��Ϣ��
					//׼����ȡcookie�е�valueת��user����session
					ObjectMapper mapper=new ObjectMapper();
					String value = loginCookie.getValue();
					value = EncodeCUtil.decrypt(Constants.ENCODE_KEY, value);
					System.out.println("���ܺ�"+ value);
					List<String> namepwd = mapper.readValue(value, List.class);
					User u = ld.selectUsersByUserNameAndUserPwd(namepwd.get(0),namepwd.get(1));
					System.out.println("��֤�ɹ�");
					
					System.out.println(u);
					session.setAttribute(Constants.USER_SESSION_KEY,u);
					
					//�鿴��ǰ���û��Ƿ��ڱ𴦵�¼
					ServletContext servletContext = request.getServletContext();
					HttpSession temp = (HttpSession) servletContext.getAttribute(u.getUserid()+"");
					if(temp != null){
					    servletContext.removeAttribute(u.getUserid()+"");
					    temp.invalidate();
					}
					servletContext.setAttribute(u.getUserid()+"",session);
					resp.sendRedirect("main.jsp");
					return;
				} catch(UserNotFoundException e){
			           request.setAttribute("msg",e.getMessage());
			           request.getRequestDispatcher("login.jsp").forward(request,resp);
			    }
        		
        	}else{
        		System.out.println("ֱ�ӷ���login.jsp");
        		filterChain.doFilter(servletRequest, servletResponse);
        		return;
        	}
        }
        
        if(uri.indexOf("login.do") != -1|| uri.indexOf("validateCode.do") != -1){
        	filterChain.doFilter(servletRequest, servletResponse);
        }else{
            if(user !=  null){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                request.setAttribute(Constants.REQUEST_MSG,"���ȵ�¼��");
                request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }
    @Override
    public void destroy() {

    }
}
