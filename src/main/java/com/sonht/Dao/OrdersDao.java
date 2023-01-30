package com.sonht.Dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sonht.Entity.Cart;
import com.sonht.Entity.CartDetails;
import com.sonht.Entity.Orders;


@Repository
public class OrdersDao extends BaseDao{
	
	
	public int getIdLastOrder() {
		String sql = "select top 1 order_id from orders order by order_id desc";
		int id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Integer.class);
		return id;
	}
	public int addOrders(Orders orders) {
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String validDate = df.format(date);
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("into orders");
		sql.append(" ( ");
		sql.append("  user_mail, order_status, order_date, order_discount_code, order_address ");
		sql.append("  ) ");
		sql.append("  values ");
		sql.append("  ( ");
		sql.append("  '" + orders.getUserMail() + "' , ");
		sql.append("  '" + orders.getStatus() + "' , ");
		sql.append("  '" + validDate + "' , ");
		sql.append("  '" + orders.getDiscount() + "' , ");
		sql.append("  '" + orders.getAddress() + "' ");
		sql.append("  ); ");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	public int addOrdersDetail(Cart c) {
		List<CartDetails> products = c.getItems();
		int id = getIdLastOrder();
		String sql = "insert into orders_detail values ("
				+ id + ","
				+ products.get(0).getProduct().getId() + ","
				+ (products.get(0).getQuantity() * products.get(0).getProduct().getPrice()) + ","
				+ (float) products.get(0).getProduct().getPrice()
				+ ")";
		int insert = _jdbcTemplate.update(sql);
		return insert;
	}
}
