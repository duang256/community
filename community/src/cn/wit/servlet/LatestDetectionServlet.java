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

import cn.wit.pojo.User;
import cn.wit.service.LatestDetectionService;
import cn.wit.serviceImpl.LatestDetectionServiceImpl;

/**
 * Servlet implementation class LatestDetectionServlet
 */
@WebServlet("/latestDetection.do")
public class LatestDetectionServlet extends HttpServlet {
	
	private LatestDetectionService service = new LatestDetectionServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int uid = user.getUserid();
		
		String latestDetection = request.getParameter("latestDetection");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateParse;
	    try {
			dateParse = sdf.parse(latestDetection);
			user.setLatestDetection(dateParse);
			service.updateLatestDetectionDao(uid, dateParse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    request.getRequestDispatcher("/dateToString.do").forward(request, response);
	}

}
