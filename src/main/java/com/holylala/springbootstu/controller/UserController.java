package com.holylala.springbootstu.controller;

import com.holylala.springbootstu.aspect.service.UserService;
import com.holylala.springbootstu.aspect.validator.UserValidator;
import com.holylala.springbootstu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//定义控制器
@Controller
// 定义类请求路径
@RequestMapping("/user")
public class UserController {

	// 注入用户服务
	@Autowired
	private UserService userService;

	// 定义请求 http://localhost:8077/user/print?id=1&userName=huang&note=1234
	@RequestMapping("/print")
	// 返回json
	@ResponseBody
	public User printUser(Long id, String userName, String note) {
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setNote(note);
		userService.printUser(user);//userService代理对象生成
		return user;
	}

	 //定义请求
	@RequestMapping("/vp")
	// 返回json
	@ResponseBody
	public User validateAndPrint(Long id, String userName, String note) {
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setNote(note);
		// 强制转换
		UserValidator userValidator = (UserValidator) userService;
		// 验证用户是否为空
		//user = null;
		if (userValidator.validate(user)) {
			userService.printUser(user);
		}
		return user;
	}

//	@RequestMapping("/manyAspects")
//	public String manyAspects() {
//		userService.manyAspects();
//		return "manyAspects";
//	}

}
