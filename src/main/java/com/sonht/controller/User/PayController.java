package com.sonht.controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sonht.Entity.Cart;
import com.sonht.Entity.Orders;
import com.sonht.Service.User.CartServiceImpl;
import com.sonht.controller.BaseController;


@Controller
public class PayController extends BaseController{
	@Autowired
	private CartServiceImpl cartServiceImpl = new CartServiceImpl();
	
	@RequestMapping(value = "pay", method = RequestMethod.POST)
	public String pay(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("name");
		String discount = request.getParameter("discount");
		String address = request.getParameter("address");
		Cart cart  = (Cart) session.getAttribute("cart");
		if(username.equals("") || address.equals(""))
		{
			session.setAttribute("error", "Please type in your name and address");
			return "redirect:cart";
		}
		Orders orders = new Orders(username, 2, discount, address, "" , null);
		if (cartServiceImpl.addOrders(orders) > 0) {
			cartServiceImpl.addOrderDetail(cart);
		}
		return "redirect:home";
	}
	
	@RequestMapping(value = "showCart", method = RequestMethod.GET)
	public ModelAndView showCart(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/cart/showCart");
		return _mvShare;
	}
}
