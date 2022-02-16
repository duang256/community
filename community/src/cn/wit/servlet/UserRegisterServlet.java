package cn.wit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wit.pojo.CommunityInfo;
import cn.wit.pojo.HouseHold;
import cn.wit.pojo.User;
import cn.wit.service.UserRegisterService;
import cn.wit.serviceImpl.UserRegisterServiceImpl;

/**
 * Servlet implementation class AdminRegisterServlet
 */
@WebServlet("/userRegister.do")
public class UserRegisterServlet extends HttpServlet {
	private UserRegisterService service = new UserRegisterServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 接收表单数据
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String identitynumber = request.getParameter("identitynumber");
        String phonenumber = request.getParameter("phonenumber");
        String communityname = request.getParameter("communityname");
        String location = request.getParameter("location");
        String unit = request.getParameter("unit");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        
        try {
			// 封装对象
			User user = new User();
			CommunityInfo community = new CommunityInfo();
			HouseHold household = new HouseHold();
			user.setUsername(username);
			user.setPassword(password);
			user.setName(name);
			user.setSex(Integer.parseInt(sex));
			user.setIdentityNumber(identitynumber);
			user.setPhoneNumber(phonenumber);
			community.setCommunityname(communityname);
			community.setLocation(location);
			household.setUnit(unit);
			household.setBuliding(Integer.parseInt(building));
			household.setRoom(Integer.parseInt(room));
			user.setCommunityInfo(community);
			user.setHousehold(household);
			
			// 调用service方法
			service.userRegister(user);
			response.sendRedirect("login.jsp");
		} catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
	}

}
