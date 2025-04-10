package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import java.util.*;
@RestController
public class SeoulRestController {
	// 필요한 객체 => 데이터베이스 연동 => ~DAO
	String[] tables= {"","SEOUL_LOCATION","SEOUL_NATURE","SEOUL_SHOP","SEOUL_FOOD"};
	String[] titles= {"","서울 명소","서울 자연","서울 쇼핑","서울 음식"};
	private SeoulService service;
	
	@Autowired
	public SeoulRestController(SeoulService service)
	{
		this.service=service;
	}
	@GetMapping(value = "seoul/list_vue.do",produces = "text/plain;charset=UTF-8" )
	public String seoul_list_vue(int page,int type) throws Exception
	{
		int rowSize= 12;
		int start = (rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+10;
		Map map = new HashMap();
		map.put("table_name", tables[type]);
		System.out.println(tables[type]);
		map.put("start", start);
		map.put("end", end);
		List<SeoulVO> list = service.seoulListData(map);
		int totalpage = service.seoulTotalPage(map);
		if(endPage>totalpage) endPage=totalpage;
		
		
		
		
		map = new HashMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		map.put("title", titles[type]);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping( value = "seoul/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String seoul_detail(int no,int type) throws Exception
	{
		Map map = new HashMap();
		map.put("table_name", tables[type]);
		map.put("no", no);
		SeoulVO vo = service.seoulDetailData(map);
		String address=vo.getAddress();
		address=address.substring(address.indexOf(" ")+1);
		map = new HashMap();
		map.put("vo", vo);
		map.put("address", address.trim());
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		return json;
	}
}
