package com.sist.web;

import org.apache.commons.collections.map.HashedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class SeoulRestController {
	@Autowired
	private SeoulDAO sdao;
	@GetMapping("seoul/list_vue.do")
	public ResponseEntity<Map> seoul_list(int page,String table_name)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start =(rowSize*page)-(rowSize-1);
			int end = (rowSize*page);
			
			map.put("start", start);
			map.put("end",end);
			map.put("table_name", table_name);
			List<SeoulVO> list= sdao.seoulListData(map);
			int totalpage=sdao.seoulTotalPage(map);
			final int BLOCK = 10;
			int startPage= ((page-1)/BLOCK*BLOCK)+1;
			int endPage= ((page-1)/BLOCK*BLOCK)+10;
			if(endPage>totalpage) endPage=totalpage;
			map = new HashMap();
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
		}catch(Exception ex)
		{
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	 @GetMapping("seoul/detail_vue.do")
	   public ResponseEntity<Map> seoul_detail(int no,String table_name)
	   {
		 Map map =new HashedMap();
		   try
		   {
			   List<FoodVO> list = new ArrayList<FoodVO>();
			   map.put("no", no);
			   map.put("table_name", table_name);
			   SeoulVO vo=sdao.seoulDetailData(map);
			   String address=vo.getAddress();
			   int index=address.indexOf("서울");
			   if(index>=0)
			   {
				   if(index!=0) {
					   address=address.substring(address.indexOf("서울"));
					   System.out.println(address);
					   vo.setAddress(address);
				   }
				   String[] parts = address.split(" ");
				   address=parts[1];
				   System.out.println("찐"+address);
				   list = sdao.foodRecommandData(address);
			   }
			   else {
				   address="서울";
				   list=sdao.foodRecommandData(address);
			   }
			   map=new HashedMap();
			   map.put("vo", vo);
			   map.put("list", list);
			   
		   }catch(Exception ex) 
		   {
			   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		   return new ResponseEntity<>(map,HttpStatus.OK);
	   }
}
