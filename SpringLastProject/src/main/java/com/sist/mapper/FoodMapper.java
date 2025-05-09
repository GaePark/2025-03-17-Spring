package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FoodMapper {
	@Select("SELECT fno,name,poster,replycount,likecount,hit,num "
			+ "FROM(SELECT fno,name,poster,replycount,likecount,hit,rownum as num "
			+ "FROM (SELECT fno,name,poster,replycount,likecount,hit "
			+ "FROM busan_food ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM busan_food")
	public int foodTotalData();
}
