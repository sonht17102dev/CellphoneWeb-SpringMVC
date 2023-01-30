package com.sonht.controller.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sonht.Dao.ProductsDao;
import com.sonht.controller.BaseController;

@Controller
public class HomeController extends BaseController{
	@Autowired
	private ProductsDao productsDao;
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		_mvShare.addObject("listProduct", _homeService.get6Products());
		_mvShare.setViewName("user/index");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int countPage = _homeService.getAllProducts().size();
		int endPage = countPage / 6;
		if(countPage % 6 != 0) {
			endPage++;
		}
		_mvShare.addObject("endPage", endPage);
		_mvShare.addObject("tag", index);
		return _mvShare;
	}
	
	
	
	@RequestMapping(value="pagingPageProduct")
	public ModelAndView pagingPage(HttpServletRequest request) {
		_mvShare.setViewName("user/index");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int countPage = _homeService.getAllProducts().size();
		int endPage = countPage / 6;
		if(countPage % 6 != 0) {
			endPage++;
		}
		_mvShare.addObject("endPage", endPage);
		_mvShare.addObject("tag", index);
		_mvShare.addObject("listProduct", productsDao.getPagingPageProduct(index));
		
		return _mvShare;
	}
}
