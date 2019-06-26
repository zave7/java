package com.kitri.cafe.common.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kitri.cafe.common.dao.CommonDao;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int getNextSeq() {
		return sqlsession.getMapper(CommonDao.class).getNextSeq();
	}

	@Override
	public void updateHit(int seq) {
	}
	
}
