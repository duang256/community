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
@WebServlet("/deleteConcentrationQuarantine.do")
public class DeleteConcentrationQuarantineServlet extends HttpServlet {
	
	private DeleteQuarantineService service = new DeleteQuarantineServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String concentrationid = request.getParameter("concentrationid");
		
		service.delConcentrationQuaratine(Integer.parseInt(uid), Integer.parseInt(concentrationid));
		
		request.getRequestDispatcher("/concentrationQuarantineUserPage.do").forward(request, response);
	}

}
