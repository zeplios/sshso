package org.zhangfc.demo4ss.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	public List<String> getAllUsernames() {
		List<String> users = new ArrayList<String>();
		users.add("zhangsan");
		users.add("lisi");
		users.add("wangwu");
		return users;
	}

}
