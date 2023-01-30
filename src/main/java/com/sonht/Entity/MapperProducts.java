package com.sonht.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProducts implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("product_id"));
		product.setName(rs.getString("product_name"));
		product.setDescription(rs.getString("product_des"));
		product.setPrice(rs.getFloat("product_price"));
		product.setSrc(rs.getString("product_img_source"));
		product.setBrand(rs.getString("product_brand"));
		product.setType(rs.getString("product_type"));
		return product;
	}

}
