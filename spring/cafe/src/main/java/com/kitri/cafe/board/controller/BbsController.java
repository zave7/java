package com.kitri.cafe.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.cafe.board.service.BbsService;
import com.kitri.cafe.common.service.CommonService;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	private CommonService commonService;
		
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter, Model model) {
		model.addAttribute("parameter", parameter);
	}
}
