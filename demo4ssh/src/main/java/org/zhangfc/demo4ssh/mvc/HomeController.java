package org.zhangfc.demo4ssh.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhangfc.demo4ssh.domain.User;
import org.zhangfc.demo4ssh.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String home(){
		List<User> us = new ArrayList<User>();
		User u = new User();
		u.setUsername("zhangsan");
		us.add(u);
		u = new User();
		u.setUsername("wangwu");
		us.add(u);
		userService.saveUsers(us);
		return "index";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<User> json(){
		return userService.getAllUsers();
	}
}
