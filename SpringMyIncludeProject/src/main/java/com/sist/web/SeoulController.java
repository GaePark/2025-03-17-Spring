package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.*;
import com.sist.commons.CommonsPagination;
import com.sist.service.*;
import java.util.*;
@Controller
public class SeoulController {
	@Autowired
	private SeoulService service;
	
	@GetMapping("seoul/detail.do")
	public String seoul_detail(int no,Model model)
	{
		SeoulVO vo = service.seoulFoodDetailData(no);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp","../seoul/detail.jsp");
		return "main/main";
	}
	@RequestMapping("seoul/find.do")
	public String seoul_find(String page,String fd,Model model)
	{
		if(fd==null||fd=="") fd="*";
		Map map = CommonsPagination.pageConfig(page, 12);
		map.put("fd", fd);
		List<SeoulVO> list = service.seoulFindListData(map);
		int totalpage= service.seoulFindTotalPage(map);
		int curpage=(int)map.get("curpage");
		final int BLOCK = 10;
		int startPage= ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage= ((curpage-1)/BLOCK*BLOCK)+10;
		if(endPage>totalpage) endPage=totalpage;
		
		model.addAttribute("list", list);
    	model.addAttribute("curpage", curpage);
    	if(fd.equals("*"))fd="";
    	model.addAttribute("fd",fd);
    	model.addAttribute("totalpage", totalpage);
    	model.addAttribute("startPage", startPage);
    	model.addAttribute("endPage", endPage);		
		model.addAttribute("main_jsp","../seoul/find.jsp");
		return"main/main";
	}
}
