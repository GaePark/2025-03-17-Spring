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
/*
 * ResponseEntity
 * 	결과값 / 상태코드 (200,505,500,600) / 헤더값을 모두
 *  프론트로 전송
 *  에러 코드를 상세하게 전송
 *  => 프론트에서 서버에서 받아온 데이터를 화면 표시할 때 사용
 *     일반 웹에서 사용 => 프로미스(promise)
 */
public class RecipeRestController {
	@Autowired
	private RecipeDAO rdao;
	@GetMapping("recipe/list.do")
	public ResponseEntity<Map> recipe_list(int page)
	{
		Map map=new HashMap();
		try
		{
			int rowSize=12;
			int start =(rowSize*page)-(rowSize-1);
			int end = (rowSize*page);
					
			List<RecipeVO> list= rdao.recipeListData(start, end);
			int count=rdao.recipeTotalPage();
			int totalpage=(int) (Math.ceil(count/12.0));
			
			final int BLOCK = 10;
			int startPage= ((page-1)/BLOCK*BLOCK)+1;
			int endPage= ((page-1)/BLOCK*BLOCK)+10;
			if(endPage>totalpage) endPage=totalpage;
			map = new HashMap();
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("count", count);
		}catch(Exception ex)
		{
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("recipe/detail_vue.do")
	public ResponseEntity<Map> recipe_detail_vue(int no)
	{
		Map map = new HashedMap();
		try {
			RecipeDetailVO vo = rdao.recipeDetailData(no);
			List<String> mlist=new ArrayList<String>();
			List<String> ilist=new ArrayList<String>();
			String[] datas=vo.getFoodmake().split("\n");
			for(String s:datas)
			{
				StringTokenizer st = new StringTokenizer(s,"^");
				mlist.add(st.nextToken());
				ilist.add(st.nextToken());
			}
			map.put("vo", vo);
			map.put("mlist", mlist);
			map.put("ilist", ilist);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
