package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.po.*;

@Controller
public class OrdersController {
	
	
	@RequestMapping("/tofindOrdersWithUser")
	public String tofindOrdersWithUser() {
		return "orders";
	}
	
	@RequestMapping("/findOrdersWithUser")
	public String findOrdersWithUser(Orders orders) {
		Integer orderId=orders.getOrdersId();
		User user=orders.getUser();
		System.out.println("id="+orderId);
		System.out.println("name"+user.getUsername());
		System.out.println("password"+user.getPassword());
		return "success";
		
	}
	
}
