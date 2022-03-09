package cn.wit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.common.PageInfo;
import cn.wit.pojo.Admin;
import cn.wit.pojo.User;
import cn.wit.service.AllUserPageService;
import cn.wit.serviceImpl.AllUserPageServiceImpl;

/**
 * Servlet implementation class VaccineUserPageServlet
 */
@WebServlet("/vaccineUserPage.do")
public class VaccineUserPageServlet extends HttpServlet {
	AllUserPageService service = new AllUserPageServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int communityid = ((Admin)(req.getSession().getAttribute("admin"))).getCommunityInfo().getCommunityid();
		System.out.println(communityid);
		String pageNumber=req.getParameter("vpageNumber");
		String pageSize=req.getParameter("vpageSize");
		System.out.println(pageNumber + ":" + pageSize);
		PageInfo<User> pi = service.selectVaccineUserPage(communityid, pageNumber, pageSize);
		
		System.out.println("piÎª¿Õ£¿" + (pi == null));
		if(pi!=null){
			req.setAttribute("pi", pi);
			req.getRequestDispatcher("admin/vaccineUserPage.jsp").forward(req, resp);
		}
	}
}
