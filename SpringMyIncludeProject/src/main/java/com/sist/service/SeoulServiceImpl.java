package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.vo.*;
import java.util.*;
import com.sist.dao.*;

@Service
public class SeoulServiceImpl implements SeoulService {
	@Autowired
	private SeoulDAO sDao;
	@Autowired
	private BoardDAO bDao;
	@Override
	public List<SeoulVO> seoulFoodListData(Map map)
	{
		return sDao.seoulFoodListData(map);
	}
	@Override
	public int seoulFoodTotalPage(int rowSize)
	{
		return sDao.seoulFoodTotalPage(rowSize);
	}
	@Override
	public SeoulVO seoulFoodDetailData(int no) {
		// TODO Auto-generated method stub
		return sDao.seoulFoodDetailData(no);
	}
	
	@Override
	public List<SeoulVO> seoulFindListData(Map map) {
		// TODO Auto-generated method stub
		return sDao.seoulFindListData(map);
	}
	
	@Override
	public int seoulFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return sDao.seoulFindTotalPage(map);
	}
	@Override
	public List<BoardVO> boardListData(Map map) {
		// TODO Auto-generated method stub
		return bDao.boardListData(map);
	}
	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		return bDao.boardDetailData(no);
	}
	@Override
	public void boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardUpdate(vo);
		
	}
	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardInsert(vo);
	}
	@Override
	public void boardDelete(int no) {
		// TODO Auto-generated method stub
		bDao.boardDelete(no);
	}
}
