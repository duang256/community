package cn.wit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.common.Constants;
import cn.wit.exception.AdminNotFoundException;
import cn.wit.pojo.Admin;
import cn.wit.service.AdminLoginService;
import cn.wit.serviceImpl.AdminLoginServiceImpl;

@WebServlet("/adminLogin.do")
public class AdminLoginServlet extends HttpServlet {

	private AdminLoginService service = new AdminLoginServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收数据 封装对象
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// 调用service查询
		try {
			Admin admin = service.adminLogin(username, password);
			// 登录成功 转发到查询所有页面
			// 将登录成功的admin对象 存储到session中
			HttpSession session = req.getSession();

			// admin其他信息封装

			session.setAttribute("admin", admin);
			session.setAttribute("login", "yes");
			
			req.getSession().setAttribute(Constants.REQUEST_MSG, "");
			resp.sendRedirect("admin/adminIndex.jsp");
			
		} catch (AdminNotFoundException e) {
			req.getSession().setAttribute(Constants.REQUEST_MSG, e.getMessage());
			resp.sendRedirect("admin/adminLogin.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}
}
