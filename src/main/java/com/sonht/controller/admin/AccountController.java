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
	
	@RequestMapping(value = "admin/createAccount", method = RequestMethod.GET)
	public ModelAndView createAccount() {
		_mvShareAdmin.setViewName("admin/createAccount");
		return _mvShareAdmin;
	}
	@RequestMapping(value = "admin/createAccount", method = RequestMethod.POST)
	public ModelAndView createAccount(HttpServletRequest request, HttpSession session) {
		String userMail = request.getParameter("usermail");
		String userName = request.getParameter("username");
		String userAddress = request.getParameter("address");
		String userPhone = request.getParameter("phone");
		String pass = request.getParameter("password");
		Account acc = new Account(userMail, pass, 1, userName, userAddress, userPhone);
		if(!acc.validate().equals("")) {
			request.setAttribute("mess", acc.validate());
			_mvShare.setViewName("admin/createAccount");
			return _mvShare;
		} else {
			acc = accountService.checkLoginExist(userMail);
			try {
				// neu account == null thi duoc signup
				if(acc == null) {
					accountService.signup(userMail, pass, userName, userAddress, userPhone);
					_mvShareAdmin.setViewName("admin/admin");
					return _mvShareAdmin;
				} else {
					throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				request.setAttribute("mess", "Account is existed!");
				_mvShareAdmin.setViewName("admin/createAccount");
				return _mvShareAdmin;
			}
		}
	}
	@RequestMapping(value = "admin/logoutAdmin", method = RequestMethod.GET)
	public String logoutAd(HttpServletRequest request, HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("listAccount");
		session.removeAttribute("usernameAdmin");
		return "redirect:/";
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
