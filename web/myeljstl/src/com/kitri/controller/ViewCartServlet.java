package com.kitri.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.kitri.dto.Product;
import com.kitri.exception.NotFoundException;
import com.kitri.service.ProductService;

@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson;
    @Override
    public void init() {
    	gson = new Gson();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userAgent = request.getHeader("User-Agent");
		System.out.println(userAgent);
		
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
		Map<Product, Integer> reqCart = null;
		if(cart != null) {
			Set<Product> keys = cart.keySet();
			reqCart = new HashMap<Product, Integer>();
			for(Product p : keys) {
				String no = p.getProd_no();
				try {
					Product p1 = ProductService.getProductService().findByNo(no);
					int quantity = cart.get(p);
					reqCart.put(p1, quantity);
				} catch(NotFoundException e) {
					
				}
			}
		}
			System.out.println("json : " + gson.toJson(reqCart));
			request.setAttribute("reqCart", reqCart);
			String path = "/viewcartresult.jsp";
			if(userAgent.contains("Dalvik")) {
				//request.setAttribute("reqCart", gson.toJson(reqCart));
				path = "/viewcartresultjson.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
