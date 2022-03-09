package cn.wit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.User;
import cn.wit.service.UpdateUserService;
import cn.wit.serviceImpl.UpdateUserServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateUser.do")
public class UpdateUserServlet extends HttpServlet {
	
	private UpdateUserService service = new UpdateUserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String identityNumber = request.getParameter("identityNumber");
		String phoneNumber = request.getParameter("phoneNumber");
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setSex(Integer.parseInt(sex));
		user.setIdentityNumber(identityNumber);
		user.setPhoneNumber(phoneNumber);
		
		service.updateUser(user);
		
		request.getRequestDispatcher("updateUserInfo.jsp").forward(request, response);
	}

}
