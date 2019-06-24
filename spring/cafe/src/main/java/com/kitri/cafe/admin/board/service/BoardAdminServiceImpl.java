package com.kitri.cafe.admin.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.admin.board.dao.BoardAdminDao;
import com.kitri.cafe.admin.board.model.BoardListDto;
import com.kitri.cafe.admin.board.model.BoardTypeDto;
import com.kitri.cafe.admin.board.model.CategoryDto;

@Service
public class BoardAdminServiceImpl implements BoardAdminService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardListDto> getBoardMenuList(int ccode) {
		return sqlSession.getMapper(BoardAdminDao.class).getBoardMenuList(ccode);//인터페이스를 통한 매퍼 호출
																					//매퍼에서 namespace와 id를 동일하게 만들어 주면 사용 가능하다
	}

	@Override
	public List<CategoryDto> getCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeCagegory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardTypeDto> getBoardTypeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeBoard(BoardListDto boardListDto) {
		// TODO Auto-generated method stub
		
	}

}
