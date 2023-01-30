package com.sonht.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonht.Dao.ProductsDao;
import com.sonht.Entity.Product;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductsDao productsDao;
	@Override
	public Product getProductById(int id) {
		return productsDao.getProductById(id);
	}
	@Override
	public List<Product> pagingPageProduct(int index) {
		return productsDao.getPagingPageProduct(index);
	}
	
}
