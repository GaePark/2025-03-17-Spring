package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class RouterController {
	@GetMapping("main/main.do")
	public String main_main(Model model)
	{
		model.addAttribute("main_jsp","../recipe/list.jsp");
		return "main/main";
	}
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model)
	{
		model.addAttribute("no",no);
		model.addAttribute("main_jsp","../recipe/detail.jsp");
		return "main/main";
	}
	@GetMapping("food/list.do")
	public String food_list(Model model)
	{
		model.addAttribute("main_jsp","../food/list.jsp");
		return "main/main";
	}
	@GetMapping("food/detail.do")
	public String food_detail(Model model)
	{
		model.addAttribute("main_jsp","../food/detail.jsp");
		return "main/main";
	}
	@GetMapping("seoul/location.do")
	public String seoul_location(Model model)
	{
		model.addAttribute("table_name","seoul_location");
		model.addAttribute("main_jsp","../seoul/location.jsp");
		return "main/main";
	}
	@GetMapping("seoul/shop.do")
	public String seoul_shop(Model model)
	{
		model.addAttribute("main_jsp","../seoul/shop.jsp");
		model.addAttribute("table_name","seoul_shop");
		return "main/main";
	}
	@GetMapping("seoul/location_detail.do")
	public String seoul_location_detail(Model model)
	{
		model.addAttribute("table_name","seoul_location");
		model.addAttribute("main_jsp","../seoul/detail.jsp");
		return "main/main";
	}
	@GetMapping("seoul/shop_detail.do")
	public String seoul_shop_detail(Model model)
	{
		model.addAttribute("table_name","seoul_shop");
		model.addAttribute("main_jsp","../seoul/detail.jsp");
		return "main/main";
	}
}
