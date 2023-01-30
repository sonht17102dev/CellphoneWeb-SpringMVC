package com.sonht.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sonht.Entity.MapperProducts;
import com.sonht.Entity.Product;

@Repository
public class SearchDao extends BaseDao{
	public List<Product> searchByName(String txtSearch){
		String sql = "select * from products where product_name like '%"+txtSearch+"%';";
		List<Product> list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
}
