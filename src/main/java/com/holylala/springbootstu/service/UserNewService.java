package com.holylala.springbootstu.service;

import com.holylala.springbootstu.model.User;
import org.springframework.stereotype.Service;

//@Service 注入了 @Component 注解 也需@ComponentScan指定扫描
@Service
public class UserNewService {
	public void printUser(User user) {
		System.out.println("编号:" + user.getId());
		System.out.println("用户名称:" + user.getUserName());
		System.out.println("备注:" + user.getNote());
	}
}
