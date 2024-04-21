package com.test.feedback_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.test.feedback_system.dto.Feedback;

public class FeedbackDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Feedback saveFeedbackDao(Feedback feedback) {
		entityTransaction.begin();
		entityManager.persist(feedback);
		entityTransaction.commit();
		return feedback;
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> getAllFeedbacks() {
		Query query = entityManager.createQuery("from Feedback");
		return query.getResultList();

	}

}
