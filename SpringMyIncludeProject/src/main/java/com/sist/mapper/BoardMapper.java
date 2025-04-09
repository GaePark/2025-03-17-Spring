package com.sist.mapper;

import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.BoardVO;

public interface BoardMapper {
	@Select("SELECT no,name,subject,regdate,hit,num "
			+ "FROM (SELECT no,name,subject,regdate,hit,rownum as num "
			+ "FROM (SELECT no,name,subject,regdate,hit "
			+ "FROM springreplyboard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	@Select("SELECT CEIL(COUNT*)/20.0) FROM springreplyboard")
	public int boardListTotalPage();
	
	@Update("UPDATE springreplyboard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	@Select("SELECT * FROM springreplyboard "
			+ "WHERE no=#{no}") 
	public BoardVO boardDetailData(int no);
	
	@Update("UPDATE name,subject,content SET "
			+ "name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	@Select("SELECT pwd FROM springreplyboard "
			+ "WHERE no=#{no}")
	public int boardPwdCheck(BoardVO vo);
	
	@Insert("INSERT INTO springreplyboard("
			+ "no,name,subject,content,pwd,group_id) "
			+ "VALUES(srb_no_seq.nextval,#{subject},#{content},#{pwd},"
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard)))")
	public void boardInsert(BoardVO vo);
	
	@Delete("DELETE FROM springreplyboard "
			+ "WHERE no=#{no}") 
	public void boardDelete(int no);
}
