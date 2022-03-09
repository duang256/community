package cn.wit.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.User;

/**
 * Servlet implementation class DateToStringServlet
 */
@WebServlet("/dateToString.do")
public class DateToStringServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user.getLatestDetection() != null){
			Date date = user.getLatestDetection();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String string = sdf.format(date);
			request.setAttribute("date", string);
			System.out.println(string);
		}
		request.getRequestDispatcher("latestDetection.jsp").forward(request, response);
	}

}
