package com.test.feedback_system.service;

import com.test.feedback_system.dao.StudentDao;
import com.test.feedback_system.dto.Feedback;
import com.test.feedback_system.dto.Student;

public class StudentService {

	StudentDao dao = new StudentDao();

	public Student updateFeedbackByStudentIdService(String studentId, Feedback feedback) {
		return dao.updateFeedbackByStudentIdDao(studentId, feedback);
	}

}
