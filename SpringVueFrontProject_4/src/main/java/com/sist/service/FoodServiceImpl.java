package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO dao;

	@Override
	public List<FoodVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.foodListData(start, end);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return dao.foodTotalPage();
	}

	@Override
	public List<FoodVO> foodFindListData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindListData(map);
	}

	@Override
	public int foodFindTotalPage(String fd) {
		// TODO Auto-generated method stub
		return dao.foodFindTotalPage(fd);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}
	
}
