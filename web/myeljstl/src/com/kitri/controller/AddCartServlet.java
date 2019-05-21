package com.kitri.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.Product;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Product, Integer>();
			session.setAttribute("cart", cart);
		}
		Product product = new Product(); 
		String no = request.getParameter("no");
		product.setProd_no(no);
		//장바구니에 해당 상품이 존재하는지 확인
		
		Integer inte = cart.get(product);
		Integer quantity = Integer.parseInt(request.getParameter("count"));
		if(inte != null) {
			quantity += inte.intValue();
		}
		
		cart.put(product, quantity);
		
		String path = "addcartresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
//		System.out.println("장바구니 내용");
//		Set<Product> keys = cart.keySet();
//		for(Product key : keys) {
//			int q = cart.get(key);
//			System.out.println("상품번호 : " + key.getProd_no() + " 수량 : " + q + " 해시코드 : " + key.hashCode());
//		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
