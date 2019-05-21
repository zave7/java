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
		try {
			Customer customer = dao.selectById(id);
			if(pass.equals(customer.getPass())) {
				return "1";
			} else {
				return "-1";
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
			return "-1";
		}
	}
}

