package com.lockedme.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lockedme.dao.UserDAO;
import com.lockedme.exception.BusinessException;
import com.lockedme.model.User;

public class UserDaoImpl implements UserDAO {

	private static Map<String, User> userMap = new LinkedHashMap<String, User>();

	public User addUser(User user) throws BusinessException {
		userMap.put(user.getUserName(), user);
		return user;
	}
	
	public void deleteUser(String userName) throws BusinessException {
		if (userMap.containsKey(userName)) {
			userMap.remove(userName);
		} else {
			throw new BusinessException("No User with id " + userName);
		}

	}

	public List<User> getAllUsers() throws BusinessException {
		List<User> userList = new ArrayList<User>(userMap.values());
		return userList;
	}

	public User getUser(String userName) throws BusinessException {
		if (userMap.containsKey(userName)) {
			return userMap.get(userName);
		} else {
			throw new BusinessException("Entered Id " + userName + " doesnt exist");
		}
	}

}