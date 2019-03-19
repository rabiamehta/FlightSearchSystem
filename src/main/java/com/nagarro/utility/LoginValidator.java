package com.nagarro.utility;

import com.nagarro.model.User;

public class LoginValidator {
	public static boolean validateInput(User user) {
		boolean result = Boolean.TRUE;
		if (user.getUserName() == null || user.getPassword() == null) {
			result = Boolean.FALSE;
		}
		return result;
	}
}
