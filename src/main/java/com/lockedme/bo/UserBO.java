package com.lockedme.bo;

import com.lockedme.exception.BusinessException;
import com.lockedme.model.User;

public interface UserBO{

	public User addUser(User user) throws BusinessException;
	public User getUser(String userName) throws BusinessException;
	public void deleteUser(String userName) throws BusinessException;
}