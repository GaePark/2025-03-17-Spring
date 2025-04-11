package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.DataBoardVO;

public interface DataBoardService {
	public List<DataBoardVO> databoardListData(Map map);
	public int databoardTotalPage();
	public void dataBoardInsert(DataBoardVO vo);
	public DataBoardVO dataBoardDetailData(int no);
}
