package org.zhangfc.demo4ssh.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhangfc.demo4ssh.service.PersonService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("")
	public String home(){
		personService.findById(0, 1);
		return "index";
	}
}
