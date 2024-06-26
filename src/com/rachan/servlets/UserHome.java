package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.constant.UserRole;
import com.shashi.utility.TrainUtil;

@SuppressWarnings("serial")
@WebServlet("/userhome")
public class UserHome extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		TrainUtil.validateUserAuthorization(req, UserRole.CUSTOMER);
		RequestDispatcher rd = req.getRequestDispatcher("UserHome.html");
		rd.include(req, res);
		pw.println("<div class='tab'>" + "" + "	Hello " + TrainUtil.getCurrentUserName(req)
				+ " ! Welcome to our new SWRTC Website" + "" + "	</div>");
		pw.println("<div class='tab'>USER HOME</div>");
		pw.println("<div class='tab'><p1 class='menu'>Hello " + TrainUtil.getCurrentUserName(req)
				+ " ! Good to See You here.<br/> Explore Side Menu for booking train "
				+ ", train schedule, fare enquiry and many more information.<br/>"
				+ "" + "</p1></div>");

	}

}
