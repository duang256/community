package cn.wit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.common.PageInfo;
import cn.wit.pojo.Admin;
import cn.wit.service.AllUserPageService;
import cn.wit.serviceImpl.AllUserPageServiceImpl;

/**
 * Servlet implementation class QuarantineUserPageServlet
 */
@WebServlet("/quarantineUserPage.do")
public class QuarantineUserPageServlet extends HttpServlet {
	AllUserPageService service = new AllUserPageServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int communityid = ((Admin)(req.getSession().getAttribute("admin"))).getCommunityInfo().getCommunityid();
		String pageNumber=req.getParameter("pageNumber");
		String pageSize=req.getParameter("pageSize");
		PageInfo pi = service.selectQuarantineUserPage(communityid, pageNumber, pageSize);
		System.out.println("piΪ?գ?" + pi == null);
		if(pi!=null){
			req.setAttribute("pi", pi);
			req.getRequestDispatcher("admin/quarantinePage.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

