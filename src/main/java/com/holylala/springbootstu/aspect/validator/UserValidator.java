package com.holylala.springbootstu.aspect.validator;

import com.holylala.springbootstu.model.User;

/**
 * 用户检测接口
 */
public interface UserValidator {

	public boolean validate(User user);

}
