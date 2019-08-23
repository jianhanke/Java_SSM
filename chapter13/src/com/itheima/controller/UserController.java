package com.itheima.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.po.User;
import com.itheima.vo.UserVO;


@Controller
public class UserController {
	
	@RequestMapping("/selectUser")
	public String selectUser(Integer id) {
	System.out.println("ID="+id);
		return "success";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	@RequestMapping("/registerUser")
	public String registerUser(User user) {
		String username=user.getUsername();
		Integer password=user.getPassword();
		System.out.println("usrname="+username);
		System.out.println("password="+password);
		return "success";
	}
	
	@RequestMapping("/toUser")
	public String selectUsers() {
		return "user";
	}
	@RequestMapping("/deleteUsers")
	public String deleteUsers(Integer[] ids) {
		if(ids!=null) {
			for(Integer id : ids) {
				System.out.println("删除了.."+id);
			}
		}else {
			System.out.println("ids=null");
		}
		return "success";
	}
	
	@RequestMapping("/toUserEdit")
	public String toUserEdit() {
		return "user_edit";
	}
	
	@RequestMapping("/editUsers")
	public String editUsers(UserVO userList) {
		List<User> users=userList.getUsers();
		for(User user : users) {
			if(user.getId()!=null) {
				System.out.println("修改了id为"+user.getId()+"用户名为"+user.getUsername());
			}
		}
		return "success";
	}
	
	
}
