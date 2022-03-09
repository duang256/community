package cn.wit.servlet;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wit.pojo.Temperature;
import cn.wit.pojo.User;
import cn.wit.service.TemperatureService;
import cn.wit.serviceImpl.TemperatureServiceImpl;

/**
 * Servlet implementation class ClockInTemperatureServlet
 */
@WebServlet("/clockInTemperature.do")
public class ClockInTemperatureServlet extends HttpServlet {
	
	TemperatureService temperatureService = new TemperatureServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int uid = user.getUserid();
		
		String temperature = request.getParameter("temperature");
		String date = request.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateParse;
	    try {
	    	System.out.println(date);
			dateParse = sdf.parse(date);
			
			Temperature tem = new Temperature();
		    tem.setTemperature(Double.parseDouble(temperature));
		    tem.setDate(dateParse);
		    tem.setUid(uid);
		    
		    temperatureService.addUserTemperature(tem);
		    
		    
		    List<Temperature> temperatureList = user.getTemperatureList();
		    temperatureList.add(tem);
		    user.setTemperatureList(temperatureList);
		  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    request.getRequestDispatcher("/addTemperature.jsp").forward(request, response);
	}

}
