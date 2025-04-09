package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.dao.RecipeDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.RecipeVO;

@Service
public class FoodRecipeServiceImpl implements FoodRecipeService {
	@Autowired
	private FoodDAO fdao;
	
	@Autowired
	private RecipeDAO rdao;

	@Override
	public List<FoodVO> foodListData() {
		// TODO Auto-generated method stub
		return fdao.foodListData();
	}

	@Override
	public List<RecipeVO> recipeListData() {
		// TODO Auto-generated method stub
		return rdao.recipeListData();
	}
	
}
