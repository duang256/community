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
 * Servlet implementation class AllUserPageServlet
 */
@WebServlet("/allUserPage.do")
public class AllUserPageServlet extends HttpServlet {
	AllUserPageService allUserPage=new AllUserPageServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int communityid = ((Admin)(req.getSession().getAttribute("admin"))).getCommunityInfo().getCommunityid();
		String pageNumber=req.getParameter("pageNumber");
		String pageSize=req.getParameter("pageSize");
		System.out.println("alluserpage" + ":" +pageNumber+":" + pageSize);
		PageInfo pi = allUserPage.selAllUserByPage(communityid, pageNumber, pageSize);
		System.out.println("piÎª¿Õ£¿" + (pi == null));
		if(pi!=null){
			req.setAttribute("pi", pi);
			req.getRequestDispatcher("admin/allUserPage.jsp").forward(req, resp);
		}
	}
}
