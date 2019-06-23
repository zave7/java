package com.kitri.service;

import java.util.List;

import com.kitri.dao.OrderDao;
import com.kitri.dto.OrderInfo;
import com.kitri.exception.AddException;
//서비스 단의 메서드는 유즈케이스별로 구현한다
public class OrderService {
	private OrderDao orderDao;
	
	public OrderService() {
		orderDao = new OrderDao();
	}
	public void addOrder(OrderInfo info) throws AddException {
		orderDao.insert(info);
	}
	public List<OrderInfo> findById(String id) {
		return orderDao.selectById(id);
	}
}
