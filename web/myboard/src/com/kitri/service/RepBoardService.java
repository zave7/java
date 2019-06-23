package com.kitri.service;

import java.util.List;

import com.kitri.dao.RepBoardDao;
import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;

public class RepBoardService {
	private RepBoardDao dao;
	public RepBoardService() {
		dao = new RepBoardDao();
	}
	public void write(RepBoard repBoard) throws AddException {
		repBoard.setParent_seq(0);//퍼포먼스??
		dao.insert(repBoard);
	}
	public void reply(RepBoard repBoard) throws AddException {
		if(repBoard.getParent_seq() == 0) {
			throw new AddException("부모글번호가 없는 답글입니다.");
		}
		dao.insert(repBoard);
	}
	public List<RepBoard> findByRows(int startRow, int endRow) {
		return dao.selectByRows(startRow, endRow);
	}
	public int getTotalCnt() {
		return dao.selectTotalCnt();
	}
	public RepBoard viewBoard(String board_seq) { //게시글 상세페이지
		return dao.viewByBoardSeq(board_seq);
	}
	
}
