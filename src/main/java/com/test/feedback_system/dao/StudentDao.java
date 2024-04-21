package com.test.feedback_system.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.test.feedback_system.dto.Feedback;
import com.test.feedback_system.dto.Student;

public class StudentDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	FeedbackDao dao = new FeedbackDao();

	public Student getStudentByIdDao(String id) {
		return entityManager.find(Student.class, id);
	}

	public Student updateFeedbackByStudentIdDao(String studentId, Feedback feedback) {
		Student student = getStudentByIdDao(studentId);
		if (student != null) {
			Feedback feedback2 = dao.saveFeedbackDao(feedback);
			if (feedback2 != null) {
				student.setFeedback(feedback2);
				entityTransaction.begin();
				entityManager.merge(student);
				entityTransaction.commit();
			}
		}
		return student;
	}
}
