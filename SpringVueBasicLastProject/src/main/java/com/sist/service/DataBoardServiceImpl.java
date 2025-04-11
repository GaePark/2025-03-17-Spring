package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class DataBoardServiceImpl implements DataBoardService {
	@Autowired
	private DataBoardDAO dao;

	@Override
	public List<DataBoardVO> databoardListData(Map map) {
		// TODO Auto-generated method stub
		return dao.databoardListData(map);
	}

	@Override
	public int databoardTotalPage() {
		// TODO Auto-generated method stub
		return dao.databoardTotalPage();
	}

	@Override
	public void dataBoardInsert(DataBoardVO vo) {
		// TODO Auto-generated method stub
		dao.dataBoardInsert(vo);
	}

	@Override
	public DataBoardVO dataBoardDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.dataBoardDetailData(no);
	}

	
	
}
