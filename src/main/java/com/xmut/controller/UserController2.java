package com.xmut.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xmut.dao.UserMapper;
import com.xmut.pojo.User;

@Controller
@RequestMapping({ "/home" })
public class UserController2 {
	private Logger logger = Logger.getLogger(UserController2.class);
	@Autowired
	UserMapper userMapper;

	@PostMapping("/user")
	public String user(Map<String, Object> model) {
		User user = userMapper.findUserByName("admin");
		if (user != null) {
			logger.info("user.getAge" + user);
		}
		model.put("name", user.getName());
		model.put("password", user.getPwd());
		return "user";
	}
}