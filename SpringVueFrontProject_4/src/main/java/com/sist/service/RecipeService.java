package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.*;

public interface RecipeService {
	public List<RecipeVO> recipeListData(int start,int end);
	public int recipeTotalPage();
	public List<RecipeVO> recipeFindListData(Map map);
	public int recipeFindTotalPage(String fd);
	public RecipeDetailVO recipeDetailData(int no);
}
