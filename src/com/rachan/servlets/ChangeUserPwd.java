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
@WebServlet("/adminhome")
public class ChangeUserPwd extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		TrainUtil.validateUserAuthorization(req, UserRole.ADMIN);
		RequestDispatcher rd = req.getRequestDispatcher("AdminHome.html");
		rd.include(req, res);
		pw.println("<div class='tab'>" + "" + "	Hello " + TrainUtil.getCurrentUserName(req)
				+ " ! Welcome to our new SWRTC Website" + "" + "	</div>");
		pw.println("<div class='tab'>ADMIN HOME</div>");
		pw.println("<div class='tab'><p1 class='menu'>Explore Side Menu to manage train details.</div>");

	}

}
