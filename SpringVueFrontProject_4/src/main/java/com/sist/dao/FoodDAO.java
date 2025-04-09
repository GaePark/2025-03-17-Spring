package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodListData( int start,int end)
	{
		return mapper.foodListData(start, end);
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	public List<FoodVO> foodFindListData(Map map)
	{
		return mapper.foodFindListData(map);
	}
	public int foodFindTotalPage(String fd)
	{
		return mapper.foodFindTotalPage(fd);
	}
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
}
