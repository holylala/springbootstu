package com.holylala.springbootstu.aspect.validator.impl;

import com.holylala.springbootstu.aspect.validator.UserValidator;
import com.holylala.springbootstu.model.User;
import org.springframework.stereotype.Service;

public class UserValidatorImpl implements UserValidator {

	@Override
	public boolean validate(User user) {
		System.out.println("引入新的接口："+ UserValidator.class.getSimpleName());
		return user != null;
	}

}
