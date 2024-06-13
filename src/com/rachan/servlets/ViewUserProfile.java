package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.UserBean;
import com.shashi.constant.UserRole;
import com.shashi.utility.TrainUtil;

@SuppressWarnings("serial")
@WebServlet("/viewuserprofile")
public class ViewUserProfile extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		TrainUtil.validateUserAuthorization(req, UserRole.CUSTOMER);

		UserBean ub = TrainUtil.getCurrentCustomer(req);
		RequestDispatcher rd = req.getRequestDispatcher("UserHome.html");
		rd.include(req, res);
		pw.println("<div class='main'><span class='m1'><a href='viewuserprofile'>View Profile</a></span>&nbsp;"
				+ "<span class='m1'><a href='edituserprofile'>Edit Profile</a></span>&nbsp;"
				+ "</div>");
		pw.println("<div class='tab'>USER PROFILE</div>");
		pw.println("<div class='tab'>" + "<table>" + "<tr><td>Profile Photo :</td><td>Not Available</td></tr>"
				+ "<tr><td>User Name :</td><td>" + ub.getMailId() + "</td></tr>"
				+ "<tr><td>Password :</td><td><input type='password' disabled value='" + ub.getPWord() + "'/></td></tr>"
				+ "<tr><td>First Name :</td><td>" + ub.getFName() + "</td></tr>" + "<tr><td>Last Name :</td><td>"
				+ ub.getLName() + "</td></tr>" + "<tr><td>Address :</td><td>" + ub.getAddr() + "</td></tr>"
				+ "<tr><td>Phone No:</td><td>" + ub.getPhNo() + "</td></tr>" + "<tr><td>Mail Id :</td><td>"
				+ ub.getMailId() + "</td></tr>" + "</table>" + "</div>");

	}

}
