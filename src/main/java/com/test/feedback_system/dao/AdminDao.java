package com.test.feedback_system.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.test.feedback_system.dto.Admin;

public class AdminDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Admin getAdminByEmail(String email) {
		return entityManager.find(Admin.class, email);
	}

}
