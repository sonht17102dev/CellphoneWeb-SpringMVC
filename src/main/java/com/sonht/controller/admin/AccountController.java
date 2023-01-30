package com.sonht.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.sonht.Entity.Account;
import com.sonht.Service.User.AccountServiceImpl;
import com.sonht.controller.BaseController;

@Controller
public class AccountController extends BaseController{
	@Autowired
	private AccountServiceImpl accountService;
	
	@RequestMapping(value = "admin/login", method = RequestMethod.GET)
	public String adminLogin(HttpSession session) {
		return "admin/account/login";
	}
	
	@RequestMapping(value = "admin/checkLogin", method = RequestMethod.POST)
	public ModelAndView loginAdmin(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Account ad = accountService.search(username, password, 2);
		
		if (username != null && password != null) {
			if (username.trim().equals("") && password.trim().equals("")) {
				_mvShareAdmin.addObject("error", "Please enter username and password");
				_mvShareAdmin.setViewName("admin/account/login");
				return _mvShareAdmin;
			} 
			else if (ad != null && username.equalsIgnoreCase(ad.getUsr()) && password.equals(ad.getPwd())
					&& ad.getRole() == 2) {
				session.setAttribute("usernameAdmin", "Welcome<br/>" + ad.getName());
				List<Account> list = accountService.getAllAccounts();
				session.setAttribute("listAccount", list);
				_mvShareAdmin.setViewName("admin/admin");
				return _mvShareAdmin;
			} 
			else {
				_mvShareAdmin.addObject("error", "Username or password is invalid");
				_mvShareAdmin.setViewName("admin/account/login");
				return _mvShareAdmin;
			}
		}
		_mvShareAdmin.addObject("error", "");
		_mvShareAdmin.setViewName("admin/account/login");
		return _mvShareAdmin;
	}
	@RequestMapping(value = "admin/logoutAdmin", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.removeAttribute("listAccount");
		session.removeAttribute("usernameAdmin");
		return "admin/admin";
	}
	
	@RequestMapping(value = "admin/DeleteAccount", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest request, HttpSession session) {
		String urs = request.getParameter("usermail");
		accountService.deleteAccount(urs);
		List<Account> list = accountService.getAllAccounts();
		session.setAttribute("listAccount", list);
		return "admin/admin";
	}
	
	@RequestMapping(value = "admin/EditAccount", method = RequestMethod.GET)
	public String selectAccountEdit(HttpServletRequest request) {
		String urs = request.getParameter("usermail");
		Account account = accountService.getAccountByUserMail(urs);
		request.setAttribute("account", account);
		return "admin/editAccount";
	}
	@RequestMapping(value = "admin/EditAccount", method = RequestMethod.POST)
	public String editAccount(HttpServletRequest request, HttpSession session) {
		String uPass = request.getParameter("password");
		String uRole = request.getParameter("role");
		String uName = request.getParameter("username");
		String uAddress = request.getParameter("address");
		String uPhone = request.getParameter("phone");
		String uMail = request.getParameter("usermail");
		accountService.editAccount(uName, uPass, Integer.parseInt(uRole), uAddress, uPhone, uMail);
		List<Account> list = accountService.getAllAccounts();
		session.setAttribute("listAccount", list);
		return "admin/admin";
	}
}
