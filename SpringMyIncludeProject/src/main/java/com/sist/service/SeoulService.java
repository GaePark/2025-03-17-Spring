package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.BoardVO;
import com.sist.vo.SeoulVO;

public interface SeoulService {
	public List<SeoulVO> seoulFoodListData(Map map);
	public int seoulFoodTotalPage(int rowSize);
	public SeoulVO seoulFoodDetailData(int no);
	public List<SeoulVO> seoulFindListData(Map map);
	public int seoulFindTotalPage(Map map);
	
	public List<BoardVO> boardListData(Map map);
	public BoardVO boardDetailData(int no);
	public void boardUpdate(BoardVO vo);
	public void boardInsert(BoardVO vo);
	public void boardDelete(int no);
}
