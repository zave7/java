package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kitri.cafe.board.dao.ReboardDao;
import com.kitri.cafe.board.model.ReboardDto;
import com.kitri.cafe.common.dao.CommonDao;
import com.kitri.cafe.util.CafeConstance;
import com.kitri.cafe.util.NumberCheck;
@Service
public class ReboardServiceImpl implements ReboardService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(ReboardDto reboardDto) {
		//클라이언트단에서 유효성검사를 했지만 서버측에서도 해줘야한다.
		//클라이언트 쪽에서 스트립트 조작가능
		//spring validation 이용
		int cnt = sqlSession.getMapper(ReboardDao.class).writeArticle(reboardDto);
		return cnt != 0 ? reboardDto.getSeq() : 0;
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> parameter) {
		int pg = NumberCheck.NotNumberToOne(parameter.get("pg"));
		System.out.println("pg : " + pg);
		int endRow = pg * CafeConstance.ARTICLE_SIZE;
		int startRow = endRow - CafeConstance.ARTICLE_SIZE;
		parameter.put("endRow", endRow+"");
		parameter.put("startRow", startRow+"");
		return sqlSession.getMapper(ReboardDao.class).listArticle(parameter);
	}

	@Override
	@Transactional//트랜잭션 관리!!
	public ReboardDto viewArticle(int seq) {
		sqlSession.getMapper(CommonDao.class).updateHit(seq);
		ReboardDto reboardDto =  sqlSession.getMapper(ReboardDao.class).viewArticle(seq);
		reboardDto.setContent(reboardDto.getContent().replace("\n", "<br>"));
		return reboardDto;
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteArticle(int seq) {
		// TODO Auto-generated method stub
		
	}

}
