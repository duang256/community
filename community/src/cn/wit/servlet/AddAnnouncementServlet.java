package cn.wit.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.Admin;
import cn.wit.pojo.Announcement;
import cn.wit.service.AnnouncementService;
import cn.wit.serviceImpl.AnnouncementServiceImpl;

/**
 * Servlet implementation class AddAnnouncementServlet
 */
@WebServlet("/addAnnouncement.do")
public class AddAnnouncementServlet extends HttpServlet {
	
	private AnnouncementService service = new AnnouncementServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		int communityid = admin.getCommunityInfo().getCommunityid();
		
		String title = request.getParameter("title");
		String announcetime = request.getParameter("announcetime");
		String content = request.getParameter("content");
		
		Announcement announcement = new Announcement();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateParse;
		try {
			dateParse = sdf.parse(announcetime);
			announcement.setTitle(title);
			announcement.setAnnouncetime(dateParse);
			announcement.setContent(content);
			announcement.setCommunityid(communityid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		service.addAnnouncement(announcement);
		
		request.getRequestDispatcher("/selectAllAnnouncement.do").forward(request, response);
	}

}
