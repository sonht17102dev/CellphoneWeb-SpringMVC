package com.sonht.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sonht.Entity.Account;
import com.sonht.Service.User.AccountServiceImpl;
import com.sonht.controller.BaseController;

@Controller
public class HomeAdminController extends BaseController{
	@Autowired
	private AccountServiceImpl accountService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView indexAdmin(HttpSession session) {
		List<Account> list = accountService.getAllAccounts();
		session.setAttribute("listAccount", list);
		_mvShareAdmin.setViewName("admin/admin");
		return _mvShareAdmin;
	}
}
