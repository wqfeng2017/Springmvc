package com.tz.spring.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tz.spring.entity.User;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@RequestMapping("/testSpringMvc") 
	public String test(HttpServletRequest req,Model model){
		req.setAttribute("test", "this is a test!");
		model.addAttribute("user", "zhangsan");
		
		return "test";
	}
	@RequestMapping("/loginUser") 
	public String loginUser(@RequestParam("uname")String username,@RequestParam("upass")String password,Model model){
		model.addAttribute("username", username);
		model.addAttribute("password",password);
		return "sun";
	}
	@RequestMapping("/registerUser") 
	public String registerUser(User user,Model model){
		model.addAttribute("user",user);
		return "sun";
	}
	
	public ModelAndView modelAndView(HttpServletRequest req){
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView("username");
		session.setAttribute("username",mv);
		return mv;
	}
}
