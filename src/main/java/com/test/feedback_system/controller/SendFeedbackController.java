package com.test.feedback_system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.feedback_system.dao.StudentDao;
import com.test.feedback_system.dto.Feedback;
import com.test.feedback_system.dto.Student;
import com.test.feedback_system.dto.Teacher;

@SuppressWarnings("serial")
@WebServlet(value = "/sendFeedback")
public class SendFeedbackController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String teacher = req.getParameter("teacher");
		String feedback = req.getParameter("feedback");
		System.out.println(id);
		System.out.println(teacher);
		System.out.println(feedback);
		Teacher teacher2 = new Teacher(teacher);
		Student student = new StudentDao().getStudentByIdDao(id);
		Feedback feedback2 = null;

		if (student != null) {
			feedback2 = new Feedback(feedback, teacher2, student);
		}
		Student student2 = new StudentDao().updateFeedbackByStudentIdDao(id, feedback2);
		resp.sendRedirect("index.jsp");
	}

}
