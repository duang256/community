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
import cn.wit.service.UpdateVaccineService;
import cn.wit.serviceImpl.UpdateVaccineServiceImpl;

/**
 * Servlet implementation class UpdateVaccineServlet
 */
@WebServlet("/updateVaccine.do")
public class UpdateVaccineServlet extends HttpServlet {
	
	private UpdateVaccineService service = new UpdateVaccineServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int uid = user.getUserid();
		
		// 获取三次疫苗时间
		String firstVaccine = request.getParameter("firstVaccine");
		String secondVaccine = request.getParameter("secondVaccine");
		String thirdVaccine = request.getParameter("thirdVaccine");
		
		// 将疫苗时间由String转换为Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date first;
		Date second;
		Date third;
		try {
			first = sdf.parse(firstVaccine);
			second = sdf.parse(secondVaccine);
			third = sdf.parse(thirdVaccine);
			
			user.setFirstVaccine(first);
			user.setSecondVaccine(second);
			user.setThirdVaccine(third);
			
			service.updateVaccine(uid, first, second, third);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("updateVaccine.jsp").forward(request, response);
		
	}

}
