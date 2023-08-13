package com.john.omikujiForm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/omikuji")
	public String form() {
		return "OmikujiForm.jsp";
	}
	
	@RequestMapping(value="/omikuji/submit", method=RequestMethod.POST)
	public String submit(HttpSession session,
		@RequestParam(value="number") Integer number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String Hobby,
		@RequestParam(value="living") String living,
		@RequestParam(value="nice") String nice ) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", Hobby);
		session.setAttribute("living", living);
		session.setAttribute("nice", nice);
		
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String show() {
		
		
		return "OmikujiShow.jsp";
	}
}
