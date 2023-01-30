package com.sonht.controller.User;

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
public class AccountUserController extends BaseController{
	@Autowired
	private AccountServiceImpl accountService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		_mvShare.setViewName("user/account/login");
		return _mvShare;
	}
	
	@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$" ;
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		Account user = accountService.search(username, password, 1);
		Account acc = new Account();
		acc.setUsr(username);
		acc.setPwd(password);
		if(!password.matches(regex) || !username.matches(regexMail)) {
			session.setAttribute("error", "invalid syntax");
			_mvShare.setViewName("user/account/login");
			return _mvShare;
		}
		if (username != null && password != null) {
			if (username.trim().equals("") && password.trim().equals("")) {
				_mvShare.addObject("error", "Please enter username and password");
				_mvShare.setViewName("user/account/login");
				return _mvShare;
			} 
			else if (user != null && username.equalsIgnoreCase(user.getUsr())
					&& password.equals(user.getPwd()) && user.getRole() == 1) {
				session.setAttribute("username", "Welcome<br/>" + user.getName());
				_mvShare.setViewName("redirect:home");
				return _mvShare;
			} 
			else {
				_mvShare.addObject("error", "Username or password is invalid");
				_mvShare.setViewName("user/account/login");
				return _mvShare;
			}
		}
		_mvShare.addObject("error", "");
		_mvShare.setViewName("user/account/login");
		return _mvShare;
	}
	
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView register() {
		_mvShare.setViewName("user/account/signup");
		return _mvShare;
	}
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public ModelAndView signup(HttpServletRequest request) {
		String userMail = request.getParameter("usermail");
		String userName = request.getParameter("username");
		String userAddress = request.getParameter("address");
		String userPhone = request.getParameter("phone");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repassword");
		Account acc = new Account(userMail, pass, 1, userName, userAddress, userPhone);
		// Check all fields are validated?
		String validationResult = acc.validate();
		if (!validationResult.isEmpty()) {
			request.setAttribute("usermail", userMail);
			request.setAttribute("password", pass);
			request.setAttribute("username", userName);
			request.setAttribute("address", userAddress);
			request.setAttribute("phone", userPhone);
			request.setAttribute("error", validationResult);
			_mvShare.setViewName("user/account/signup");
			return _mvShare;
		}
		acc = accountService.checkLoginExist(userMail);
		if (!pass.equals(repass)) {
			request.setAttribute("message", "Wrong repassword");
			//request.getRequestDispatcher("signup.jsp").forward(request, response);
			_mvShare.setViewName("user/account/signup");
			return _mvShare;
		}
		if (acc == null) {
			// neu account == null thi duoc signup
			accountService.signup(userMail, pass, userName, userAddress, userPhone);
			_mvShare.setViewName("user/account/login");
			return _mvShare;
		} 
		_mvShare.setViewName("user/account/signup");
		return _mvShare;
		
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("listAccount");
		session.removeAttribute("usernameAdmin");
		return "redirect:home";
	}
}
