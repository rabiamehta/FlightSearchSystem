package com.nagarro.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.dao.LoginDao;
import com.nagarro.model.User;
import com.nagarro.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Transactional
	public boolean loginUser(User user) {
		System.out.println("in loginUser service impl");
		return loginDao.loginUser(user);
	}

}
