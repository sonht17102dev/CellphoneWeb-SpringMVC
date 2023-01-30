package com.sonht.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sonht.Entity.Product;

@Service
public interface IProductService {
	public Product getProductById(int id);
	public List<Product> pagingPageProduct(int index);
}
