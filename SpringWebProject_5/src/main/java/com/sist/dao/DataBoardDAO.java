package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> boardListData( int start, int end)
	{
		return mapper.boardListData(start, end);
	}
	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	public int boardInsert(DataBoardVO vo)
	{
		mapper.boardInsert(vo);
		return mapper.boardCurentNoData();
	}
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	public String databoardGetPassword(int no)
	{
		return mapper.databoardGetPassword(no);
	}
	public void databoardDelete(int no)
	{
		mapper.databoardDelete(no);
	}
	public int databoardFileCount(int no)
	{
		return mapper.databoardFileCount(no);
	}
	public DataBoardVO databoardUpdateData(int no)
	{
		return mapper.databoardDetailData(no);
	}
	public void databoardUpdate(DataBoardVO vo)
	{
		mapper.databoardUpdate(vo);
	}
}
