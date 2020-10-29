package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.service.*;
import java.util.*;
import java.sql.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private StatsService statsService; //방문자 서비스 클래스를 사용하기위해 
	private StaffService staffService; //관리자 서비스 클래스를 사용하기위해
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff")!=null) { // 로그인된 상태라면(세션이 존재한다면)
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		request.setAttribute("stats", map.get("stats"));
		request.setAttribute("totalCount", map.get("totalCount"));
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		staffService = new StaffService();
		Staff paramStaff = new Staff();
		
		paramStaff.setEmail(request.getParameter("id")); // login.jsp 에서 값을 받아와 집어넣는다.
		paramStaff.setPassword(request.getParameter("pw"));
		Staff loginStaff = staffService.getStaffByKey(paramStaff);
		System.out.println(loginStaff+"<<<loginStaff");
		HttpSession session = request.getSession();
		
		if(loginStaff != null) {
			String staffEmail = loginStaff.getEmail();
			String userName = loginStaff.getUsername();
			
			request.setAttribute("staffEmail", staffEmail);
			request.setAttribute("userName", userName);
			
		
			session.setAttribute("loginStaff", loginStaff);
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		response.sendRedirect(request.getContextPath()+"/LoginServlet");
	}

}
