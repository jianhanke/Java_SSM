package com.itheima.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/hello")
public class FirstController  {

	@RequestMapping(value="/firstController")
	public  String handleRequest  (HttpServletRequest arg0, HttpServletResponse arg1,Model model ) throws Exception {
		model.addAttribute("msg","这是第二个");
		return "first";
		
	}
	
}
