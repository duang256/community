package cn.wit.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import cn.wit.common.*;
import cn.wit.exception.UserNotFoundException;
import cn.wit.pojo.User;
import cn.wit.service.UserLoginService;
import cn.wit.serviceImpl.UserLoginServiceImpl;

@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
    	String remember = req.getParameter("remember");

        try{
            HttpSession session = req.getSession();
            String codeTemp = (String)session.getAttribute(Constants.VALIDATE_CODE_KEY); //session��֤��
            if(codeTemp.equals(code)){
                UserLoginService userLoginService = new UserLoginServiceImpl();
                User user = userLoginService.userLogin(username, password);
                //�����ͻ��������˵ĻỰ״̬

                session.setAttribute(Constants.USER_SESSION_KEY,user);
        		
                ServletContext servletContext = this.getServletContext();
                HttpSession temp = (HttpSession) servletContext.getAttribute(user.getUserid()+"");
                if(temp != null){
                    servletContext.removeAttribute(user.getUserid()+"");
                    temp.invalidate();
                }
                servletContext.setAttribute(user.getUserid()+"",session);
                
                System.out.println(remember);
                
				if("1".equals(remember)){
					//˵���û���ѡ��"��ס��"
					ObjectMapper om=new ObjectMapper();
					//ת��Ϊjson:{"username":"root","password":"root"}
					List<String> namepwd = new ArrayList();
					namepwd.add(user.getUsername());
					namepwd.add(user.getPassword());
					
					String userJson = om.writeValueAsString(namepwd);
					System.out.println("����ǰ" + userJson);
					//����
					userJson = EncodeCUtil.encrypt(Constants.ENCODE_KEY, userJson);
					System.out.println("���ܺ�" + userJson);
					Cookie userCookie=new Cookie(Constants.USER_COOKIE,userJson);
					//����cookieЯ��·��Ϊ������Ŀ��Я��
					userCookie.setPath("/");
					//����cookie��Ч��(7��),cookie�Ĺ���ʱ���ǻ��������õ�(sessionҲ��)
					userCookie.setMaxAge(60*60*24*7);
					resp.addCookie(userCookie);
					System.out.println("cookie������");
	            }
				//ʹ���ض���ʽ��ת��ҳ
                resp.sendRedirect("main.jsp");
           }else{
               req.setAttribute(Constants.REQUEST_MSG,"��֤����������������");
               req.getRequestDispatcher("login.jsp").forward(req,resp);
           }	
        }catch(UserNotFoundException e){
           req.setAttribute("msg",e.getMessage());
           req.getRequestDispatcher("login.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
