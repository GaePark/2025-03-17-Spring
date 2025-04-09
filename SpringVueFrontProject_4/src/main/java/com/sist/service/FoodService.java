package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData( int start,int end);
	public int foodTotalPage();
	public List<FoodVO> foodFindListData(Map map);
	public int foodFindTotalPage(String fd);
	public FoodVO foodDetailData(int fno);
}
