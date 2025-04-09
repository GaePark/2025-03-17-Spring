package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.RecipeService;

//화면 변경 => forward => request 전송
//return "폴더/파일명"
//sendRedirect => 이미 만들어진 화면으로 이동
//--- request(model) 전송이 불가능 _ok
//return "redirect: list.do"
//리던형 => void(다운로드) ,String
/*
* 1. 매칭
*    사용자 URI 매칭 => 메소드를 찾아서 호출
*    -------------
*    @GetMapping(URI)
*    @PostMapping
*    ------------- + @RequestMapping
* 2. 매개변수
*    => request.getParameter를 처리후에 매개변수에 전송
*       --------------------
*       => 사용자 전송한 데이터는 String 
*       => 변환후 받는 경우
*       (String page) (int page)
*                     ========== 모든 데이터 값을 가지고 있는 경우
*       => 여러개 데이터를 동시에 String[] , List
*                            -------    ----
*                            checkbox   file[0]...
*       => VO단위 값을 받을 수 있다 : 커멘드 객체
*           ?no=10 ....
*           <form>
*           <input type=text name=name>
*           <input type=text name=subject>
*           </form>
*       => 객체 사용이 가능
*          -------------
*          Model => 전송
*          HttpServlectRequest
*          HttpServletResponse
*          HttpSession
*          RedirectAttributes
*       => 매개변수는 순서가 없다
*       
*       1. 사용자 요청값 받기 => 매개변수
*       2. 요청처리후 JSP로 값 전송
*                  -----------
*                  model.addAttribute()
*           ㅣ
*          DAO
*          ---
*          
*/
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;
@RestController
public class RecipeRestController {
	// 스프링에 저장되는 객체를 가지고 온다 => 스프링에서는 지역변수는 제어가
		// 스프링은 전역변수만 제어 가능 => @Autowired
	@Autowired
	private RecipeService service;
	@GetMapping(value = "recipe/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		List<RecipeVO> list = service.recipeListData(start, end);
		int totalpage= service.recipeTotalPage();
		
		Map map=new HashMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		return json;
	}
	@GetMapping(value="recipe/find_vue.do",produces = "text/plain;charset=UTF-8")
	public String find_vue(int page,String fd) throws Exception
	{
		if(fd.equals("")) fd="*";
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
		List<RecipeVO> list = service.recipeFindListData(map);
		int totalpage= service.recipeFindTotalPage(fd);
		if(endPage>totalpage)
			endPage=totalpage;
		map=new HashMap();
		map.put("totalpage", totalpage);
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		return json;
	}
	@GetMapping(value = "recipe/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_detail(int no) throws Exception
	{
		RecipeDetailVO vo = service.recipeDetailData(no);
		List<String> mList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		String[] makes=vo.getFoodmake().split("\n");
		for(String m:makes)
		{
			StringTokenizer st=new StringTokenizer(m,"^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		String[] data=vo.getData().split(",");
		Map map = new HashMap();
		map.put("vo", vo);
		map.put("mList", mList);
		map.put("iList",iList);
		map.put("data", data);	
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;	
	}
}
