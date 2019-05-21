package com.kitri.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.service.OrderService;

@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderService orderService;
    public AddOrderServlet() {
    	orderService = new OrderService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//장바구니 정보가 주문테이블에 저장
		OrderInfo info = new OrderInfo();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginInfo");
		Customer customer = new Customer();
		customer.setId(id);
		info.setCustomer(customer);//주문자아이디 설정
		
		List<OrderLine> lines = new ArrayList<OrderLine>();
		//장바구니 상품번호, 수량->OrderLine에 설정
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
		for(Product p : cart.keySet()) {
			int quantity = cart.get(p);
			OrderLine orderLine = new OrderLine();
			orderLine.setProduct(p);
			orderLine.setOrder_quantity(quantity);
			lines.add(orderLine);
		}
		info.setLines(lines);
		String result= "";
		try {
			orderService.addOrder(info);
			session.removeAttribute("cart");
			result = "1";
		} catch (AddException e) {
			e.printStackTrace();
			result = "-1";
		}
		String path = "/addorderresult.jsp";
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
