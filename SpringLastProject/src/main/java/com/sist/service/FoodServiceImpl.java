package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO fdao;
	
	@Override
	public List<FoodVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fdao.foodListData(start, end);
	}

	@Override
	public int foodTotalData() {
		// TODO Auto-generated method stub
		return fdao.foodTotalData();
	}

}
