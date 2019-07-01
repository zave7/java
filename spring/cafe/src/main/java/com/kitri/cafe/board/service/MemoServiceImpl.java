package com.kitri.cafe.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.board.dao.MemoDao;
import com.kitri.cafe.board.model.MemoDto;
@Service
public class MemoServiceImpl implements MemoService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeMemo(MemoDto memoDto) {
		return sqlSession.getMapper(MemoDao.class).writeMemo(memoDto);
	}

	@Override
	public String listMemo(int seq) {
		return makeJson(seq);
	}

	@Override
	public void modifyMemo(MemoDto memoDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deleteMemo(int seq, int mseq) {
		System.out.println("deleteMemo : " + seq + " " + mseq);
		sqlSession.getMapper(MemoDao.class).deleteMemo(mseq);
		return makeJson(seq);
	}

	private String makeJson(int seq) {
		List<MemoDto> list =  sqlSession.getMapper(MemoDao.class).listMemo(seq);
		JSONArray array = new JSONArray(list);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("memolist", array);
		return jsonObject.toString();
	}
}
