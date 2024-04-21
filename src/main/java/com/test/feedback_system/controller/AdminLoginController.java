package com.test.feedback_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.feedback_system.dto.Admin;
import com.test.feedback_system.service.AdminService;

@SuppressWarnings("serial")
@WebServlet(value = "/adminLogin")
public class AdminLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession httpSession = req.getSession();
		Admin admin = (Admin) httpSession.getAttribute("admin");

		Admin admin2 = new AdminService().loginAdminByAdminEmailAndPassService(email, password);
		if (admin2 != null || admin == null) {
			req.getSession();
			resp.sendRedirect("main.jsp");
		} else {
			resp.sendRedirect("index.jsp");
		}
	}

}
