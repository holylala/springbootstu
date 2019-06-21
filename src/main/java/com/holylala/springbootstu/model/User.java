package com.holylala.springbootstu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//注解@Component表明这个类将被Spring IoC容器扫描分配 需要再使用@ComponentScan指定扫描的包
@Component("user")
//@Scope(WebApplicationContext.SCOPE_REQUEST) SpringMVC 环境中 同一个请求共用同一个Bean 第二次请求会产生新的Bean
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) 每次都返回不同的bean对象 非单例
public class User {

	//@Value 在
	// @Autowired
	//private User user; 这种方式引用时生效

	@Value("1")
	private Long id;
	@Value("user_name_1")
	private String userName;
	@Value("note_1")
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
