package com.sonht.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sonht.Entity.MapperProducts;
import com.sonht.Entity.Product;


@Repository
public class ProductsDao extends BaseDao{
	public List<Product> getAllProducts(){
		String sql = "Select * from products";
		List<Product> list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	public List<Product> get6Products(){
		String sql = "Select top 6 * from products";
		List<Product> list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	public Product getProductById(int id) {
		String sql = "select * from products where product_id = " + id;
		Product product = _jdbcTemplate.queryForObject(sql, new MapperProducts());
		return product;
	}
	
	public List<Product> getPagingPageProduct(int index){
		index = (index - 1) * 6;
		String sql = "select * from Products\r\n"
				+ "order by product_id\r\n"
				+ "OFFSET "+ index +" ROWS FETCH NEXT 6 ROWS ONLY";
		
		List<Product> list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
		
	}
}
