package com.kitri.cafe.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kitri.cafe.board.model.AlbumDto;
import com.kitri.cafe.board.service.AlbumService;
import com.kitri.cafe.common.service.CommonService;
import com.kitri.cafe.member.model.MemberDto;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private ServletContext servletContext;// 내장객체

	@Autowired
	private CommonService commonService;

	@Autowired
	private AlbumService albumService;

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter, Model model) {
		model.addAttribute("parameter", parameter);
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(AlbumDto albumDto, @RequestParam("picture") MultipartFile multipartFile,
			@RequestParam Map<String, String> parameter, Model model, HttpSession session) {

		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			int seq = commonService.getNextSeq();
			albumDto.setSeq(seq);
			albumDto.setId(memberDto.getId());
			albumDto.setName(memberDto.getName());
			albumDto.setEmail(memberDto.getEmail());

			if (multipartFile != null && !multipartFile.isEmpty()) {
				String originPicture = multipartFile.getOriginalFilename(); // 원본 파일 이름
				String realPath = servletContext.getRealPath("/upload/album");

				DateFormat df = new SimpleDateFormat("yyMMdd");
				String saveFolder = df.format(new Date());
				String realSaveFolder = realPath + File.separator + saveFolder;
				File dir = new File(realSaveFolder);
				if (!dir.exists())
					dir.mkdirs();

				String savePicture = UUID.randomUUID().toString()
						+ originPicture.substring(originPicture.lastIndexOf('.'));

				File file = new File(realSaveFolder, savePicture);
				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				albumDto.setOriginPicture(originPicture);
				albumDto.setSavePicture(savePicture);
				albumDto.setSaveFolder(saveFolder);
			}
//			TODO : 1. image file 검사, 2. thumbnail image
			seq = albumService.writeArticle(albumDto);

			if (seq != 0) {
				model.addAttribute("seq", seq);
			} else {
				model.addAttribute("errorMsg", "서버문제로 글작성 실패!");
			}
		} else {
			model.addAttribute("errorMsg", "로그인이 필요합니다");
		}
		model.addAttribute("parameter", parameter);
		return "reboard/writeok";
	}
}
