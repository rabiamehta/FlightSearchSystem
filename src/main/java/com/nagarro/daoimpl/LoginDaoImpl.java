package com.nagarro.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.LoginDao;
import com.nagarro.model.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean loginUser(User user) {
		Boolean result = false;
		System.out.println("inside login dao impl");
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery("from com.nagarro.model.User UID where UID.userName=\'"
				+ user.getUserName() + "\' and UID.password=\'" + user.getPassword() + "\'");
		List<User> list = query.list();

		if (!list.isEmpty()) {
			result = true;
		} else {
			System.out.println("Invalid");
		}
		System.out.println("moving out from login dao impl");
		return result;
	}

}
