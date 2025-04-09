package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Rest API
 * = GET => @GetMapping ==> SELECT
 * = POST => @PostMapping ==> INSERT
 * -------------------web
 * = PUT => @PutMapping ==> UPDATE
 * = DELETE => @DeleteMapping ==> DELETE
 * 
 * => 화면이동이 불가능
 * => JavaScript연동 => 처리 결과값을 전송
 *    -----------------JSON
 *    일반 문자열 => 그냥 전송
 *    VO => {} => 자바스크립트의 객체 표현법
 *    List => []
 *    ------------------------------ 자동 처리 jackson
 * => @ResponseBody => @RestController
 *    -------------    ---------------
 *    메소드에서 처리      클래스 단위 처리
 *    
 *    스프링 : web파일을 관리하지 안흔ㄴ다 => 서버의 역할만 수행
 *                                     -------------
 *                                     Back-End / Front-End
 *                                         ㅣ
 *                                       자바:스프링
 *                                       C# :ASP.net
 *                                       파이썬: 장고
 *                                       NodeJS = PHP
 * 
 */
@Controller
public class RecipeController {
	@GetMapping("recipe/list.do")
	public String recipe_list()
	{
		return "recipe/list";
	}
	
	@GetMapping("recipe/find.do")
	public String recipe_find()
	{
		return "recipe/find";
	}
	@GetMapping("recipe/detail.do")
	public String recipe_detail()
	{
		return "recipe/detail";	
	}
}
