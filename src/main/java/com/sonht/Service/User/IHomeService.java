package com.sonht.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonht.Entity.Product;

@Service
public interface IHomeService {
	@Autowired
	public List<Product> getAllProducts();
	public List<Product> get6Products();
}
