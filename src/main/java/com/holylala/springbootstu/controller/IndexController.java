package com.holylala.springbootstu.controller;
import com.holylala.springbootstu.model.User;
import com.holylala.springbootstu.service.UserNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //http://localhost:8077/index

    @Autowired
    private UserNewService userNewService;

    //根据类型和名称去查找bean
    @Autowired
    @Qualifier("user")
    private User user;

    @RequestMapping("/index")
    public String index() {

        userNewService.printUser(user);


        return "index";
    }
}