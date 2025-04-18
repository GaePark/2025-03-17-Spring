package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MusicMapper {
	@Insert("INSERT INTO musicdata VALUES("
			+ "(SELECT NVL(MAX(no)+1,1) FROM musicData),"
			+ "#{title},#{singer})")
	public void musicInsert(MusicVO vo);
	
	@Delete("DELETE FROM musicdata")
	public void musicDelete();
	
	@Select("SELECT * FROM musicData "
			+ "WHERE no=1")
	public MusicVO musicTop();
	
	public void allDelete(int empno);
}
