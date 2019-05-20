package com.kitri.service;

import com.kitri.dao.OrderDao;
import com.kitri.dto.OrderInfo;
import com.kitri.exception.AddException;

public class OrderService {
	private OrderDao orderDao;
	
	public OrderService() {
		orderDao = new OrderDao();
	}
	public void addOrder(OrderInfo info) throws AddException {
		orderDao.insert(info);
	}
}
