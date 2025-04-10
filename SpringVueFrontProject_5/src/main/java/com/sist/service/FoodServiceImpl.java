package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO dao;

	@Override
	public int foodTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dao.foodTotalPage(map);
	}

	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodListData(map);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}
	
	
}
