package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(int start,int end)
	{
		return mapper.recipeListData(start, end);
	}
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	public List<RecipeVO> recipeFindListData(Map map)
	{
		return mapper.recipeFindListData(map);
	}
	public int recipeFindTotalPage(String fd)
	{
		return mapper.recipeFindTotalPage(fd);
	}
	public RecipeDetailVO recipeDetailData(int no)
	{
		return mapper.recipeDetailData(no);
	}
}
