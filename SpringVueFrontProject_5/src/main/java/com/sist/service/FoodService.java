package com.sist.service;

import java.util.*;

import com.sist.vo.FoodVO;

public interface FoodService {
	
	public int foodTotalPage(Map map);
	public List<FoodVO> foodListData(Map map);
	public FoodVO foodDetailData(int fno);
}
