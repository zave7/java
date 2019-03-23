package com.kitri.question.classQ;

public class ShopService {
	static ShopService service = new ShopService();
	static ShopService getInstance() {
		return service;
	}
}
