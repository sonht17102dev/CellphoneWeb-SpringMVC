package com.sonht.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sonht.Service.User.ProductServiceImpl;
import com.sonht.controller.BaseController;

@Controller
public class ProductController extends BaseController{
	@Autowired
	private ProductServiceImpl productService;
	
	@RequestMapping(value="detail_Product/{id}")
	public ModelAndView detailProduct(@PathVariable int id) {
		_mvShare.setViewName("user/product/detailProduct");
		_mvShare.addObject("product", productService.getProductById(id));
		
		return _mvShare;
	}
	@RequestMapping(value="list")
	public ModelAndView displayAllProduct() {
		_mvShare.setViewName("user/product/listAllProduct");
		_mvShare.addObject("products", _homeService.getAllProducts());
		
		return _mvShare;
	}
	
	
	
}
