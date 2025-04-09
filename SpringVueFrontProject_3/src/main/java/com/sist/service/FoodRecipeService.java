package com.sist.service;

import java.util.List;

import com.sist.vo.FoodVO;
import com.sist.vo.RecipeVO;

public interface FoodRecipeService {
	public List<FoodVO> foodListData();
	public List<RecipeVO> recipeListData();
}
