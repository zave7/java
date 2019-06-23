package com.kitri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.PageBean;
import com.kitri.dto.RepBoard;
import com.kitri.service.RepBoardService;

@WebServlet("/boardlist")
public class RepBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RepBoardService service;

	public RepBoardListServlet() {
		service = new RepBoardService();
	}

	// 요청 방식을 구분하지 않을 경우에 서비스 메소드를 오버라이드 한다
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cp = request.getParameter("currentPage");
		System.out.println("currentPage = "+ cp);
		int currentPage = 1;
		if (cp != null) {
			currentPage = Integer.parseInt(cp);
		}
		int cntPerPageGroup = 3; // 페이지 그룹에 보여줄 페이지 수
		int totalCnt = service.getTotalCnt(); // 총게시글 수
		int cntPerPage = 5; // 페이지 별 보여줄 목록 수
		String url = "boardlist";
		PageBean pageBean = new PageBean(
				cntPerPage, 
				totalCnt, 
				cntPerPageGroup, 
				url, 
				currentPage);
		List<RepBoard> list = service.findByRows(pageBean.getStartRow(), pageBean.getEndRow());
		pageBean.setList(list);
		// int endRow = currentPage * cntPerPage;
		// int startRow = endRow - (cntPerPage - 1);

		// request.setAttribute("boardlist", list);
//		총 페이지수 계산
		// int totalPage = 1;
		// totalPage = (totalCnt % cntPerPage) > 0 ? totalCnt/cntPerPage + 1 :
		// totalCnt/cntPerPage;
		// request.setAttribute("totalPage", totalPage);

		// int currDivGroup = (int)Math.ceil(currentPage/(float)cntPerPageGroup);
		// int endPage = currDivGroup < 2 ? cntPerPageGroup : currDivGroup *
		// cntPerPageGroup;
		// int startPage = endPage - (cntPerPageGroup - 1);
		// if(endPage > totalPage)
		// endPage = totalPage;
		System.out.println(pageBean.getStartPage());
		System.out.println(pageBean.getEndPage());
		request.setAttribute("pageBean", pageBean);
		String path = "boardlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
