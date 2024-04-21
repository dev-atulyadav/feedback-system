package com.test.feedback_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.test.feedback_system.dto.Teacher;

public class TeacherDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();


	public List<Teacher> getAllTeachers() {
		Query query = entityManager.createQuery("from Teacher");
		@SuppressWarnings("unchecked")
		List<Teacher> teachers = query.getResultList();
		return teachers;
	}

	public Teacher getTeacherByNameDao(String name) {
		return entityManager.find(Teacher.class, name);
	}

}
