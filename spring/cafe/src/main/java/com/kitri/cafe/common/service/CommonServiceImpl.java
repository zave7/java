package com.kitri.cafe.common.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kitri.cafe.common.dao.CommonDao;
import com.kitri.cafe.util.CafeConstance;
import com.kitri.cafe.util.NumberCheck;
import com.kitri.cafe.util.PageNavigation;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int getNextSeq() {
		return sqlsession.getMapper(CommonDao.class).getNextSeq();
	}

	@Override
	public PageNavigation getPageNavigation(Map<String, String> parameter) {
		PageNavigation navigation = new PageNavigation();
		int newArticleCount = sqlsession.getMapper(CommonDao.class).getNewArticeCount(Integer.parseInt(parameter.get("bcode")));
		navigation.setNewArticleCount(newArticleCount);
		int totalArticleCount = sqlsession.getMapper(CommonDao.class).getTotalArticleCount(parameter);
		navigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / CafeConstance.ARTICLE_SIZE + 1;
		navigation.setTotalPageCount(totalPageCount);
		int pg = NumberCheck.NotNumberToOne(parameter.get("pg"));
		navigation.setNowFirst(pg <= CafeConstance.PAGE_SIZE);
		navigation.setNowEnd((totalPageCount - 1) / CafeConstance.PAGE_SIZE * CafeConstance.PAGE_SIZE < pg);
//		navigation.setNowEnd((totalPageCount - pg) <= (totalPageCount % CafeConstance.PAGE_SIZE));
		navigation.setPageNo(pg);
		return navigation;
	}
	
	
	
}
