package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeDetailMapper;
import com.sist.vo.RecipeDetailVO;

@Repository
public class RecipeDetailDAO {
	@Autowired
	RecipeDetailMapper mapper;
	public RecipeDetailVO recipeDetailData(int no)
	{
		return mapper.recipeDetailData(no);
	}
}
