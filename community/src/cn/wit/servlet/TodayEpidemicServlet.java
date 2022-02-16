package cn.wit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.User;
import cn.wit.service.TodayEpidemicService;
import cn.wit.serviceImpl.TodayEpidemicServiceImpl;

/**
 * Servlet implementation class TodayEpidemicServlet
 */
@WebServlet("/todayEpidemic.do")
public class TodayEpidemicServlet extends HttpServlet {
	private TodayEpidemicService service = new TodayEpidemicServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		int[] todayEpidemic = service.TodayEpidemic(user.getCommunityInfo());
		
		request.setAttribute("todayEpidemic", todayEpidemic);
		
		request.getRequestDispatcher("todayEpidemic.jsp").forward(request, response);
		
	}

}
