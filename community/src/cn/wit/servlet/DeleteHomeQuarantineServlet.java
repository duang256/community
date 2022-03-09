package cn.wit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.service.DeleteQuarantineService;
import cn.wit.serviceImpl.DeleteQuarantineServiceImpl;


/**
 * Servlet implementation class deleteHomeQuarantineServlet
 */
@WebServlet("/deleteHomeQuarantine.do")
public class DeleteHomeQuarantineServlet extends HttpServlet {
	
	private DeleteQuarantineService service = new DeleteQuarantineServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String homeid = request.getParameter("homeid");
		
		service.delHomeQuarantine(Integer.parseInt(uid), Integer.parseInt(homeid));
		
		request.getRequestDispatcher("/quarantineUserPage.do").forward(request, response);
	}

}
