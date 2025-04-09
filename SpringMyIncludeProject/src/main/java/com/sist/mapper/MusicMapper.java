package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
import java.util.*;
public interface MusicMapper {
	@Insert("INSERT INTO aopmusic VALUES("
			+ "#{mno},#{title},#{poster},#{artist},#{album})")
	public void musicInsert(MusicVO vo);
	@Delete("DELETE FROM aopmusic")
	public void musicDelete();
	@Select("SELECT * FROM aopmusic")
	public List<MusicVO> musicListData();
}
