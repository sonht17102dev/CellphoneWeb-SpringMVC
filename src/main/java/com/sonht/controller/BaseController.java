package com.sonht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.sonht.Service.User.HomeImpl;

@Controller
public class BaseController {
	@Autowired
	public HomeImpl _homeService;
	
	public ModelAndView _mvShare = new ModelAndView();
	public ModelAndView _mvShareAdmin = new ModelAndView();
	
	
}
