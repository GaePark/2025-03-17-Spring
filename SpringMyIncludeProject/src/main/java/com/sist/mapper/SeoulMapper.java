package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.*;
public interface SeoulMapper {
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM seoul_food ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulFoodListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/#{rowSize}) FROM seoul_food")
	public int seoulFoodTotalPage(int rowSize);
	@Select("SELECT * FROM seoul_food "
			+ "WHERE no=#{no}")
	public SeoulVO seoulFoodDetailData(int no);
	@Update("UPDATE seoul_food SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	public List<SeoulVO> seoulFindListData(Map map);
	public int seoulFindTotalPage(Map map);
}
