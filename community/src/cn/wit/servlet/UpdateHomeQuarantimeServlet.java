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

import cn.wit.common.PageInfo;
import cn.wit.pojo.Admin;
import cn.wit.service.AllUserPageService;
import cn.wit.service.UpdateQuarantineService;
import cn.wit.serviceImpl.AllUserPageServiceImpl;
import cn.wit.serviceImpl.UpdateQuarantineServiceImpl;

/**
 * Servlet implementation class UpdateHomeQuarantime
 */
@WebServlet("/updateHomeQuarantime.do")
public class UpdateHomeQuarantimeServlet extends HttpServlet {
	
	private UpdateQuarantineService quarantineService = new UpdateQuarantineServiceImpl();
	private AllUserPageService userPageService = new AllUserPageServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession  session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		
		String status = request.getParameter("status");
		
		String uid = request.getParameter("uid");
		String starttime = request.getParameter("starttime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateParse;
	    try {
			dateParse = sdf.parse(starttime);
			quarantineService.updateHomeQuarantine(Integer.parseInt(uid), dateParse, status);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    int communityid = admin.getCommunityInfo().getCommunityid();
	    String pageNumber=request.getParameter("pageNumber");
		String pageSize=request.getParameter("pageSize");
	    PageInfo pi = userPageService.selectQuarantineUserPage(communityid, pageNumber, pageSize);
	    
	    request.setAttribute("pi", pi);
	    request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
