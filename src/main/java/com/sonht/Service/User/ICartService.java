package com.sonht.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonht.Entity.Cart;
import com.sonht.Entity.Orders;

@Service
public interface ICartService {
	@Autowired
	public int addOrders(Orders orders);
	public void addOrderDetail(Cart c);
}
