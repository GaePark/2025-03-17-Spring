package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;


public interface MovieMapper {
	@Insert("INSERT INTO aopMovie VALUES("
			+ "#{mno},#{title},#{poster},#{director},#{genre})")
	public void MovieInsert(MovieVO vo);
	
	@Delete("DELETE FROM aopMovie")
	public void MovieDelete();
	
	@Select("SELECT * FROM aopMovie ORDER BY mno")
	public List<MovieVO> movieListData();
	
}
