package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(project_food pk_no_pk)*/ fno,name,poster "
			+ "FROM project_food)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(project_food pk_no_pk)*/ fno,name,poster "
			+ "FROM project_food WHERE REGEXP_LIKE(name,#{fd}))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food WHERE REGEXP_LIKE(name,#{fd})")
	public int foodFindTotalPage(String fd);
	
	@Select("SELECT * FROM project_food WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
