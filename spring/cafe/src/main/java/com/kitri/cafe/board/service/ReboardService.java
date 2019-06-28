package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.ReboardDto;

public interface ReboardService {
	int writeArticle(ReboardDto reboardDto);
	List<ReboardDto> listArticle(Map<String, String> prameter);
	ReboardDto viewArticle(int seq);
	ReboardDto getArticle(int seq);
	int modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
	
	int replyArticle(ReboardDto reboardDto);
}
