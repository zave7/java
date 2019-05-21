package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.*;
import com.kitri.service.OrderService;

@WebServlet("/vieworder")
public class ViewOrderSerlvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	public ViewOrderSerlvlet() {
		service = new OrderService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginInfo");
		List<OrderInfo> orderList = service.findById(id);
		request.setAttribute("orderList", orderList);
		String path = "/vieworderresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		for(OrderInfo info : orderList) {
			List<OrderLine> lines = info.getLines();
			System.out.println("info.getOrder_no() = "+info.getOrder_no());
			System.out.println("info.getOrder_dt() = "+info.getOrder_dt());
			for(OrderLine line : lines) {
				Product p = line.getProduct();
				String prod_no = p.getProd_no();
				String prod_name = p.getProd_name();
				int prod_price = p.getProd_price();
				int prod_quantity = line.getOrder_quantity();
				System.out.println("	prod_no = "+prod_no);
				System.out.println("	prod_name = "+prod_name);
				System.out.println("	prod_price = "+prod_price);
				System.out.println("	prod_quantity = "+prod_quantity);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
