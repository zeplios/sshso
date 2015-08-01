package org.zhangfc.demo4springmvc.mvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Map<String, String> json(){
		Map<String, String> result = new HashMap<String, String>();
		result.put("zhangsan", "hello");
		result.put("lisi", "world");
		result.put("wangwu", "nihao");
		return result;
	}
}
