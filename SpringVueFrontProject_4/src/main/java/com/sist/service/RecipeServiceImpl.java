package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeDAO dao;

	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.recipeListData(start, end);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return dao.recipeTotalPage();
	}

	@Override
	public List<RecipeVO> recipeFindListData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindListData(map);
	}

	@Override
	public int recipeFindTotalPage(String fd) {
		// TODO Auto-generated method stub
		return dao.recipeFindTotalPage(fd);
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.recipeDetailData(no);
	}
	
	
	
	
}
