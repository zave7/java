package com.kitri.cafe.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoService {
	int writeMemo(MemoDto memoDto);
	List<MemoDto> listMemo(Map<String, String> prameter);
	void modifyMemo(MemoDto memoDto);
	void deleteMemo(int mseq);
}
