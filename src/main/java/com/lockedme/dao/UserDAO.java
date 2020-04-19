package com.lockedme.dao;

import java.util.List;

import com.lockedme.exception.BusinessException;
import com.lockedme.model.User;

public interface UserDAO {

	public User addUser(User user) throws BusinessException;
	public User getUser(String userName) throws BusinessException;
	public void deleteUser(String userName) throws BusinessException;
	public List<User> getAllUsers() throws BusinessException;
}