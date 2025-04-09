package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.vo.*;
import java.util.*;

import com.sist.commons.CommonsPagination;
import com.sist.service.SeoulService;

@Controller
public class BoardController {
	@Autowired
	private SeoulService service;
	
	@GetMapping("board/list.do")
	public String board_list(Model model, String page) 
	{
	if(page==null)page="1";
		Map map = CommonsPagination.pageConfig(page, 20);
		List<BoardVO> list = service.boardListData(map);
		model.addAttribute("main_jsp","../replyboard/list.jsp");
		return "main/main";
	}
}
