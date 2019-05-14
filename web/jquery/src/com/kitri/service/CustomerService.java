package com.kitri.service;

import com.kitri.dao.CustomerDAO;
import com.kitri.dto.Customer;
import com.kitri.exception.NotFoundException;

public class CustomerService {

	private static CustomerService customerService;
	
	static {
		customerService = new CustomerService();
	}
	
	private CustomerService() {
	}
	
	public static CustomerService getCustomerService() {
		return customerService;
	}
	
	
	public String login(String id, String pass) {
		CustomerDAO dao = new CustomerDAO();
		String result = "";
		try {
			Customer customer = dao.selectById(id);
//			if(pass.equals(customer.getPass())) {
			if(true) {
				result = "test" + "님 환영합니다";
			} else {
				result = "로그인에 실패하였습니다";
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
