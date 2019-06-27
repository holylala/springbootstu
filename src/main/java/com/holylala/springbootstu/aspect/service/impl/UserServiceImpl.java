package com.holylala.springbootstu.aspect.service.impl;

import com.holylala.springbootstu.aspect.service.UserService;
import com.holylala.springbootstu.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private User user = null;

	@Override
	public void printUser(User user) {
		if (user == null) {
			throw new RuntimeException("检查用户参数是否为空......");
		}
		System.out.print("id =" + user.getId());
		System.out.print("\tusername =" + user.getUserName());
		System.out.println("\tnote =" + user.getNote());
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
