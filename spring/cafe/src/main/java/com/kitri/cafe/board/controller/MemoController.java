package com.kitri.cafe.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kitri.cafe.board.model.MemoDto;
import com.kitri.cafe.board.service.MemoService;
import com.kitri.cafe.member.model.MemberDto;

@RestController
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String write(@RequestBody MemoDto memoDto, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		String json = "false";
		if(memberDto != null) {
			memoDto.setId(memberDto.getId());
			memoDto.setName(memberDto.getName());
			memoService.writeMemo(memoDto);
			json = memoService.listMemo(memoDto.getSeq());
			
		}
		return json;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(int seq) {
		String json = "false";
		json = memoService.listMemo(seq);
		return json;
	}
	
	@RequestMapping(value = "/{seq}/{mseq}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(name = "seq") int seq, @PathVariable(name = "mseq") int mseq) {
		String json = "false";
		memoService.deleteMemo(seq, mseq);
		json = memoService.listMemo(seq);
		return json;
	}
}
