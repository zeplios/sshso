package org.zhangfc.demo4ss.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhangfc.demo4ss.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<String> json(){
		return userService.getAllUsernames();
	}
}
