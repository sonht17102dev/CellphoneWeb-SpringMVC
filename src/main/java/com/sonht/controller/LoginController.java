package com.sonht.controller;

import javax.servlet.http.HttpServletRequest;
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
public class LoginController extends BaseController {
	@Autowired
	private AccountServiceImpl accountService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		// _mvShare.addObject("error", "");
		_mvShare.setViewName("user/account/login");
		return _mvShare;
	}

	@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		Account user = accountService.search(username, password, 1);
		Account adminAccount = accountService.search(username, password, 2);
		if (username != null && password != null) {
			if (username.trim().equals("") && password.trim().equals("")) {
				_mvShare.addObject("error", "Please enter username and password");
				_mvShare.setViewName("user/account/login");
				return _mvShare;
			} else if (!password.matches(regex) || !username.matches(regexMail)) {
				_mvShare.addObject("error", "Invalid syntax");
				_mvShare.setViewName("user/account/login");
				return _mvShare;
			} else if (user != null && username.equalsIgnoreCase(user.getUsr()) && password.equals(user.getPwd())
					&& user.getRole() == 1) {
				session.setAttribute("username", "Welcome<br/>" + user.getName());
				_mvShare.setViewName("redirect:home");
				return _mvShare;
			} else if (adminAccount != null && username.equalsIgnoreCase(adminAccount.getUsr())
					&& password.equals(adminAccount.getPwd()) && adminAccount.getRole() == 2) {
				session.setAttribute("username", "Welcome<br/>" + adminAccount.getName());
				_mvShare.setViewName("redirect:admin/");
				return _mvShare;
			} else {
				_mvShare.addObject("error", "Username or password is not correct");
				_mvShare.setViewName("user/account/login");
				return _mvShare;
			}
		} else {

			_mvShare.addObject("error", "");
			_mvShare.setViewName("user/account/login");
			return _mvShare;
		}
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView register() {
		_mvShare.setViewName("user/account/signup");
		return _mvShare;
	}

	@RequestMapping(value = {"signup"}, method = RequestMethod.POST)
	public ModelAndView signup(HttpServletRequest request) {
		
		String userMail = request.getParameter("usermail");
		String userName = request.getParameter("username");
		String userAddress = request.getParameter("address");
		String userPhone = request.getParameter("phone");
		String pass = request.getParameter("password");
				
		Account acc = new Account(userMail, pass, 1, userName, userAddress, userPhone);
		if(!acc.validate().equals("")) {
			request.setAttribute("mess", acc.validate());
			_mvShare.setViewName("user/account/signup");
			return _mvShare;
		} else {
			acc = accountService.checkLoginExist(userMail);
			try {
				// neu account == null thi duoc signup
				if(acc == null) {
					accountService.signup(userMail, pass, userName, userAddress, userPhone);
					_mvShare.setViewName("redirect:login");
					return _mvShare;
				} else {
					throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				request.setAttribute("mess", "Account is existed!");
				_mvShare.setViewName("user/account/signup");
				return _mvShare;
			}
				
		}
		
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("listAccount");
		session.removeAttribute("usernameAdmin");
		return "redirect:home";
	}

}
