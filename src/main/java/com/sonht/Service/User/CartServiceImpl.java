package com.sonht.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonht.Dao.OrdersDao;
import com.sonht.Entity.Cart;
import com.sonht.Entity.Orders;


@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private OrdersDao dao;

	@Override
	public int addOrders(Orders orders) {
		return dao.addOrders(orders);
	}

	@Override
	public void addOrderDetail(Cart c) {
		dao.addOrdersDetail(c);
	}
	
}
