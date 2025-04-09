package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
@RestController
public class RecipeRestController {
	@Autowired
	private FoodRecipeService service;
	
	@GetMapping(value = "recipe/list_vue.do",produces = "application/json;charset=UTF-8")
	public List<RecipeVO> recipe_list_vue()
	{
		return service.recipeListData();
	}
}
