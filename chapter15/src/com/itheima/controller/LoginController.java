package com.itheima.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itheima.po.User;

@Controller
public class LoginController {
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String toLogin(User user,Model model,HttpSession session) {
		String username=user.getUsername();
		String password=user.getPassword();
		if(username.equals("tom") && password.equals("123")) {
			session.setAttribute("user", user);
			return "redirect:showMain";
		}
		model.addAttribute("msg","’À∫≈√‹¬Î¥ÌŒÛ");
		return "login";
	}
	
	@RequestMapping("showMain")
	public String showMain() {
		return "main";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	
	
}
