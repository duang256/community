package cn.wit.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class QuarantineUserPageServlet
 */
@WebServlet("/concentrationQuarantineUserPage.do")
public class ConcentrationQuarantineUserPageServlet extends HttpServlet {
	AllUserPageService service = new AllUserPageServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int communityid = ((Admin)(req.getSession().getAttribute("admin"))).getCommunityInfo().getCommunityid();
		String pageNumber=req.getParameter("pageNumber");
		String pageSize=req.getParameter("pageSize");
		PageInfo pi = service.selectConcentrationQuarantineUserPage(communityid, pageNumber, pageSize);
		
		System.out.println("集中隔离pi为空？" + (pi == null));
		
		List<User> list = pi.getList();
		
		for(User user : list){
			System.out.println("controler测试集中隔离" + user.getUserid());
		}
		if(pi!=null){
			req.setAttribute("concentrationPi", pi);
			req.getRequestDispatcher("admin/concentrationQuarantine.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

