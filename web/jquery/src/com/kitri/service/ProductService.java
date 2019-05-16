package com.kitri.service;

import java.util.List;

import com.kitri.dao.ProductDAO;
import com.kitri.dto.Product;
import com.kitri.exception.NotFoundException;

public class ProductService {
	
	private static ProductService productService;
	
	static {
		productService = new ProductService();
	}
	
	private ProductService() {
		
	}
	
	public static ProductService getProductService() {
		return productService;
	}
	
	public List<Product> findAll() {
		return ProductDAO.getProductDAO().selectAll();
	}
	public Product findByNo(String prod_no) {
		try {
			return ProductDAO.getProductDAO().selectByNo(prod_no);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
