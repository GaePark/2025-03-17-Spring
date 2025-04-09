package com.sist.web;
import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.service.GoodsService;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("goods/")
public class GoodsController {
	@Autowired 
	private GoodsService service;
	
	@GetMapping("goods_list.do")
	public String goods_list(String page,  Model model)
	{
	if(page==null) page="1";
	int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   
	   List<GoodsVO> list = service.goodsListData(map);
	   int totalpage = service.goodsTotalData();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   // 1(1~10) 11 21...
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   // 10 20 ...
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   // food_list로 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "goods/goods_list";
	}
	@GetMapping("goods_detail_before.do")
	   public String food_detail_before(String no,
			   HttpServletResponse response,RedirectAttributes ra)
	   {
		   Cookie cookie=new Cookie("goods"+no, 
				   no);
		   cookie.setPath("/");
		   cookie.setMaxAge(60*60*24);
		   response.addCookie(cookie);
		   
		   ra.addAttribute("fno", no);// sendRedirect
		   // ?대신 사용
		   return "redirect:goods_detail.do";
	   }
	   // 상세보기 
	   @GetMapping("goods_detail.do")
	   public String food_detail(int no,Model model)
	   {
		   GoodsVO vo=service.goodsDetailData(no);
		   model.addAttribute("vo", vo);
		   return "goods/food_detail";
	   }
	   
	   
}

