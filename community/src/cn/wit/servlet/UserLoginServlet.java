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

        try{
            HttpSession session = req.getSession();
            String codeTemp = (String)session.getAttribute(Constants.VALIDATE_CODE_KEY); //session��֤��
            if(codeTemp.equals(code)){
                UserLoginService userLoginService = new UserLoginServiceImpl();
                User user = userLoginService.userLogin(username, password);
                
                //����дuser������Ϣ��װ
                user = userLoginService.selectUserInfo(user);
                
                //�洢user������Ϣ
                session.setAttribute("user", user);
                session.setAttribute("login", "yes");
                
                //�����ͻ��������˵ĻỰ״̬
				//ʹ���ض���ʽ��ת��ҳ
                resp.sendRedirect("index.jsp");
           }else{
               req.setAttribute(Constants.REQUEST_MSG,"��֤����������������");
               req.getRequestDispatcher("login.jsp").forward(req,resp);
           }	
        }catch(UserNotFoundException e){
           req.setAttribute(Constants.REQUEST_MSG,e.getMessage());
           req.getRequestDispatcher("login.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
