package com.sist.web;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO fdao;
	
	@GetMapping("food/list_vue.do")
	public ResponseEntity<Map> food_list(int page)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start =(rowSize*page)-(rowSize-1);
			int end = (rowSize*page);
					
			List<FoodVO> list= fdao.foodListData(start, end);
			int totalpage=fdao.foodTotalPage();
			
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
	 @GetMapping("food/detail_vue.do")
	   public ResponseEntity<FoodVO> food_detail(int fno)
	   {
		   FoodVO vo=new FoodVO();
		   try
		   {
			   vo=fdao.foodDetailData(fno);
			   
		   }catch(Exception ex) 
		   {
			   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		   return new ResponseEntity<>(vo,HttpStatus.OK);
	   }
}
