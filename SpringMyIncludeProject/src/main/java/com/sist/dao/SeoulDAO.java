package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulFoodListData(Map map)
	{
		return mapper.seoulFoodListData(map);
	}
	public int seoulFoodTotalPage(int rowSize)
	{
		return mapper.seoulFoodTotalPage(rowSize);
	}
	public SeoulVO seoulFoodDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.seoulFoodDetailData(no);
	}
	public List<SeoulVO> seoulFindListData(Map map)
	{
		return mapper.seoulFindListData(map);
	}
	public int seoulFindTotalPage(Map map)
	{
		return mapper.seoulFindTotalPage(map);
	}
	
}
