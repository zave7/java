package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.model.BoardDto;
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> prameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDto viewArticle(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyArticle(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteArticle(int seq) {
		// TODO Auto-generated method stub
		
	}

}
