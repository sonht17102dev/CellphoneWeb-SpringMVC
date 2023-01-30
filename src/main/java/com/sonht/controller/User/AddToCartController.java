package com.sonht.controller.User;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sonht.Dao.ProductsDao;
import com.sonht.Entity.Cart;
import com.sonht.Entity.Product;
import com.sonht.controller.BaseController;

@Controller
public class AddToCartController extends BaseController{
	@Autowired
	private ProductsDao productsDao;
	
	@RequestMapping(value = "addtocart", method = RequestMethod.GET)
	public ModelAndView redirectToCart(HttpServletRequest request, HttpSession session) {
		
		String idd = request.getParameter("id");
		String action = request.getParameter("action");
		String quantity = request.getParameter("quantity");
		int id = Integer.parseInt(idd);
		if(action != null && action.equalsIgnoreCase("add")) {
			if(session.getAttribute("cart") == null) {
				session.setAttribute("cart", new Cart());
			}
			Product p = productsDao.getProductById(id);
			Cart cart = (Cart) session.getAttribute("cart");
			cart.add(new Product(p.getId(),p.getName(),p.getDescription(),
					p.getPrice(),p.getSrc(),p.getType(),p.getBrand()), Integer.parseInt(quantity));
		}
		else if(action != null && action.equalsIgnoreCase("delete")) {
			Cart cart = (Cart) session.getAttribute("cart");
			cart.remove(id);
		}
		_mvShare.setViewName("user/cart/cart");
		return _mvShare;
	}
}
