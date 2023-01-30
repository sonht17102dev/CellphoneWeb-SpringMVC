package com.sonht.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonht.Dao.ProductsDao;
import com.sonht.Entity.Product;

@Service
public class HomeImpl implements IHomeService{
	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<Product> getAllProducts() {
		return productsDao.getAllProducts();
	}

	@Override
	public List<Product> get6Products() {
		return productsDao.get6Products();
	}
	
	
}
