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
@WebServlet("/userprofile")
public class UserProfile extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		TrainUtil.validateUserAuthorization(req, UserRole.CUSTOMER);

		RequestDispatcher rd = req.getRequestDispatcher("UserHome.html");
		rd.include(req, res);
		pw.println("<div class='main'><span class='m1'><a href='viewuserprofile'>View Profile</a></span>&nbsp;"
				+ "<span class='m1'><a href='edituserprofile'>Edit Profile</a></span>&nbsp;"
				+ "</div>");
		pw.println("<div class='tab yellow'>Hey " + TrainUtil.getCurrentUserName(req)
				+ " ! Welcome to SWRTC<br/><br/>You can edit and view your profile<br/>"
				+ "" + "</div>");

	}

}
