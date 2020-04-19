package com.lockedme.bo.impl;

import com.lockedme.bo.UserBO;
import com.lockedme.dao.UserDAO;
import com.lockedme.dao.impl.UserDaoImpl;
import com.lockedme.exception.BusinessException;
import com.lockedme.model.User;

public class UserBOImpl implements UserBO {

	private UserDAO dao;

	public UserDAO getDao() {
		if (dao == null) {
			dao = new UserDaoImpl();
		}
		return dao;
	}

	private boolean isValidUserId(String userName) {
		if ((userName + "").matches("[a-zA-Z ]{3,15}")) {
			return true;
		} else {
			return false;
		}
	}

	public User addUser(User user) throws BusinessException {
		if (user == null) {
			throw new BusinessException("Product details cannot be empty");
		} else if (!user.getUserName().matches("[a-zA-Z ]{3,15}")) {
			throw new BusinessException("Product name " + user.getUserName() + " is invalid");
		} else {
			// code here for storage layer.
			user = getDao().addUser(user);
		}

		return user;
	}

	public void deleteUser(String userName) throws BusinessException {
		if (isValidUserId(userName)) {
			getDao().deleteUser(userName);
		} else {
			throw new BusinessException("Entered Id " + userName + " is invalid");
		}

	}

	public User getUser(String userName) throws BusinessException {
		User user = null;
		if (isValidUserId(userName)) {
			user = getDao().getUser(userName);
		} else {
			throw new BusinessException("Entered Id " + userName + " is invalid");
		}
		return user;
	}

}