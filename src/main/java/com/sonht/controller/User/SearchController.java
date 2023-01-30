package com.sonht.controller.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sonht.Entity.Product;
import com.sonht.Service.User.SearchServiceImpl;
import com.sonht.controller.BaseController;

@Controller
public class SearchController extends BaseController{
	@Autowired
	private SearchServiceImpl searchService;
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest request, HttpSession session) {
		String txtSearch = request.getParameter("txt");
		List<Product> list = searchService.searchByName(txtSearch);
		/*
		 * Neu list rong, user de trong thi hien thi error
		 */
		if (list.isEmpty()) {
			session.setAttribute("error",
					"<p style='color:red; text-align: center;'><strong>Can't find product.<br>Try to find another product</strong></p>");

		} else if (txtSearch.trim().equals("")) {
			session.setAttribute("error",
					"<p style='color:red; text-align: center;'><strong>Search input can not contains space!</strong></p>");
		} else {
			session.removeAttribute("error");
			request.setAttribute("listProduct", list);
		}
		request.setAttribute("inputSearch", txtSearch); // Sử dụng EL để lưu trữ dữ liệu nhập vào trên form search
		_mvShare.setViewName("user/search/search");
		return _mvShare;
	}
	@RequestMapping(value = "search2", method = RequestMethod.GET)
	public ModelAndView searchDropDown(HttpServletRequest request, HttpSession session) {
		String text =  request.getParameter("name");
		List<Product> list11 = searchService.searchByName(text);
		List<Product> listX = searchService.searchByName(text);
		List<Product> list7 = searchService.searchByName(text);
		List<Product> list12 = searchService.searchByName(text);
		List<Product> list13 = searchService.searchByName(text);
		List<Product> list14 = searchService.searchByName(text);
		if (list7.isEmpty() || list11.isEmpty() || listX.isEmpty()) {
			session.setAttribute("error",
					"<p style='color:red; text-align: center;'><strong>Can't find product.<br>Try to find another product</strong></p>");

		} else {
			session.removeAttribute("error");
			request.setAttribute("list7", list7);
			request.setAttribute("listX", listX);
			request.setAttribute("list11", list11);
			request.setAttribute("list12", list12);
			request.setAttribute("list13", list13);
			request.setAttribute("list14", list14);
		}
		_mvShare.setViewName("user/search/search");
		return _mvShare;
	}
}
