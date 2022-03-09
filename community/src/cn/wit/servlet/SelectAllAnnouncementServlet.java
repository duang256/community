package cn.wit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.Admin;
import cn.wit.pojo.Announcement;
import cn.wit.pojo.User;
import cn.wit.service.AnnouncementService;
import cn.wit.serviceImpl.AnnouncementServiceImpl;

/**
 * Servlet implementation class SelectAllAnnouncementServlet
 */
@WebServlet("/selectAllAnnouncement.do")
public class SelectAllAnnouncementServlet extends HttpServlet {
	
	private AnnouncementService service = new AnnouncementServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int communityid = 0;
		Admin admin = (Admin) session.getAttribute("admin");
		User user = (User) session.getAttribute("user");
		
		if(admin != null) communityid = admin.getCommunityInfo().getCommunityid();
		if(user != null) communityid = user.getCommunityInfo().getCommunityid();

		List<Announcement> announcement = service.selectAnnouncement(communityid);
		
		request.setAttribute("announcement", announcement);
		
		request.getRequestDispatcher("announce.jsp").forward(request, response);
	}

}
