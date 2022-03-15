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

@WebServlet("/getConcentrationId.do")
public class GetConcentrationIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = (String) req.getParameter("id");
		req.setAttribute("id", uid);
		System.out.println("≤‚ ‘uid"+uid);
		req.getRequestDispatcher("admin/updateConcentrationQuarantine.jsp").forward(req, resp);
	}
}
