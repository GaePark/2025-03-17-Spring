package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.vo.*;


public interface DataBoardMapper {
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit, num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM springDataBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	@Select("SELECT COUNT(*)FROM springDataBoard ")
	public int boardRowCount();
	
	@Insert("INSERT INTO SPRINGDATABOARD VALUES("
			+ "stb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filecount})")
	public int boardInsert(DataBoardVO vo);
	
	@Select("SELECT NVL(MAX(no),1) FROM SPRINGDATABOARD")
	public int boardCurentNoData();
	
	@Insert("INSERT INTO SPRINGFILEINFO VALUES("
			+ "#{no},#{filename},#{filesize})")
	public void boardFileInsert(FileInfoVO vo);
	@Update("UPDATE springDataBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	@Select("SELECT * FROM springdataboard "
			+ "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	@Select("SELECT pwd FROM springdataboard "
			+ "WHERE no=#{no}")
	public String databoardGetPassword(int no);
	@Delete("DELETE FROM springdataboard "
			+ "WHERE no=#{no}")
	public void databoardDelete(int no);
	@Select("SELECT filecount FROM springdataboard "
			+ "WHERE no=#{no}")
	public int databoardFileCount(int no);
	@Update("UPDATE springdataboard SET "
			+ "name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void databoardUpdate(DataBoardVO vo);
}
