package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodService service;
	
	@GetMapping(value = "food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list_vue(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		List<FoodVO> list = service.foodListData(start, end);
		int totalpage= service.foodTotalPage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		return json;
	}
	@GetMapping(value="food/find_vue.do",produces = "application/json;charset=UTF-8")
	public Map food_find_vue(int page, String fd)
	{
		if(fd.equals(""))fd="*";
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+10;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		List<FoodVO> list = service.foodFindListData(map);
		int totalpage= service.foodFindTotalPage(fd);
		if(endPage>totalpage)
			endPage=totalpage;
		map=new HashMap();
		map.put("totalpage", totalpage);
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}
	@GetMapping(value = "food/detail_vue.do", produces = "application/json;charset=UTF-8")
	public FoodVO food_detail_vue(int fno)
	{
		return service.foodDetailData(fno);
	}
}
