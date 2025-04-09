package com.sist.dao;
import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	public List<BoardVO> boardListData(int start,int end){
		return mapper.boardListData(start, end);
	}
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}


	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		
		String db_pwd =mapper.boardGetPassword(vo.getNo());
		if(encoder.matches(vo.getPwd(), db_pwd))
		{
			mapper.boardUpdate(vo);
			bCheck=true;
		}
		/*
		 * else { bCheck=false; }
		 */
		mapper.boardUpdate(vo);
		return bCheck;
	}
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		String db_pwd =mapper.boardGetPassword(no);
		if(encoder.matches(pwd, db_pwd))
		{
			mapper.boardDelete(no);
			bCheck=true;
		}
		return bCheck;
	}
	
}
