package com.kitri.cafe.board.service;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoService {
	int writeMemo(MemoDto memoDto);
	String listMemo(int seq);
	void modifyMemo(MemoDto memoDto);
	String deleteMemo(int seq, int mseq);
}
