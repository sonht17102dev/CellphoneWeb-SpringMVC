package com.sonht.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sonht.Entity.Product;

@Service
public interface ISearchService {
	public List<Product> searchByName(String txtSearch);
}
