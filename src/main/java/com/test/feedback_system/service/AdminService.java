package com.test.feedback_system.service;

import com.test.feedback_system.dao.AdminDao;
import com.test.feedback_system.dto.Admin;

public class AdminService {

	AdminDao adminDao = new AdminDao();

	public Admin loginAdminByAdminEmailAndPassService(String email, String password) {
		Admin admin = adminDao.getAdminByEmail(email);
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				return admin;
			}
		}
		return null;
	}

}
