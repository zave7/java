package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.BbsDto;

public interface BbsService {
	int writeArticle(BbsDto bbsDto);
	List<BbsDto> listArticle(Map<String, String> prameter);
	BbsDto viewArticle(int seq);
	int modifyArticle(BbsDto bbsDto);
	void deleteArticle(int seq);
}
