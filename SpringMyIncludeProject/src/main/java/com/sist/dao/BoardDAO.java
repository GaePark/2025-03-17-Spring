package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.*;
import java.util.*;
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	public void boardUpdate(BoardVO vo)
	{
		mapper.boardUpdate(vo);
	}
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	public void boardDelete(int no)
	{
		mapper.boardDelete(no);
	}
}
