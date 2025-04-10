package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodService service;
	
	@GetMapping(value = "food/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_list_vue(int page, String type) throws Exception
	{
		int rowSize= 12;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+10;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("type", type);
		List<FoodVO> list = service.foodListData(map);
		int totalpage= service.foodTotalPage(map);
		if(endPage>totalpage) endPage=totalpage;
		map = new HashMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper= new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	@GetMapping(value = "food/detail_vue.do", produces = "application/json;charset=UTF-8")
	public FoodVO food_detail(int fno)
	{
		return service.foodDetailData(fno);
	}
}
