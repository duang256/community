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
            String codeTemp = (String)session.getAttribute(Constants.VALIDATE_CODE_KEY); //session验证码
            if(codeTemp.equals(code)){
                UserLoginService userLoginService = new UserLoginServiceImpl();
                User user = userLoginService.userLogin(username, password);
                //建立客户端与服务端的会话状态

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
					//说明用户勾选了"记住我"
					ObjectMapper om=new ObjectMapper();
					//转换为json:{"username":"root","password":"root"}
					List<String> namepwd = new ArrayList();
					namepwd.add(user.getUsername());
					namepwd.add(user.getPassword());
					
					String userJson = om.writeValueAsString(namepwd);
					System.out.println("加密前" + userJson);
					//加密
					userJson = EncodeCUtil.encrypt(Constants.ENCODE_KEY, userJson);
					System.out.println("加密后：" + userJson);
					Cookie userCookie=new Cookie(Constants.USER_COOKIE,userJson);
					//设置cookie携带路径为整个项目都携带
					userCookie.setPath("/");
					//设置cookie有效期(7天),cookie的过期时间是基于秒设置的(session也是)
					userCookie.setMaxAge(60*60*24*7);
					resp.addCookie(userCookie);
					System.out.println("cookie已设置");
	            }
				//使用重定向方式跳转首页
                resp.sendRedirect("main.jsp");
           }else{
               req.setAttribute(Constants.REQUEST_MSG,"验证码有误，请重新输入");
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
